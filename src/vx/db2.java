package vx;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class db2 {
    public static String genom;
    public static String energy;
    //
    public static String db_dir; //директория хранения базы
    public static String db_name1; //имя файла базы для кодов и генов
    public static String db_name2; //имя файла базы для логов, параметров и пр.
    public static String db_name3; //имя файла базы для энергии
    public static String app_dir; //директория приложения

    //конструктор, нужен для определения путей к базе
    public db2() {
        String relativePathToClass = db2.class.getName().replace('.', '/') + ".class";
        URL url = db2.class.getClassLoader().getResource(relativePathToClass);
        String pathToClass = url.getFile();
        String pathToRoot =
            pathToClass.substring(0, pathToClass.length() - (relativePathToClass).length() - 1 - ("classes").length());
        String t = url.getPath();

        app_dir = pathToRoot;

        db_dir = pathToRoot + "db";
        
        db_name1  = "vx1.000"; //гены
        db_name2 = "vx2.000"; // логи
        db_name3 = "vx3.000"; // энергия
        
    }

    //получение уровня энергии

    public static String getEnergyLevel(String prog_type) throws Exception {
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);
        String sTempDb = db_dir + "\\" + db_name3; 
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;
        int iTimeout = 30;

        String sMakeSelect = "SELECT level from energy WHERE type_prog ='" + prog_type + "' ";

        Connection conn = DriverManager.getConnection(sDbUrl);
        try {
            Statement stmt = conn.createStatement();

            try {
                stmt.setQueryTimeout(iTimeout);
                ResultSet rs = stmt.executeQuery(sMakeSelect);
                try {
                    while (rs.next()) {
                        String sResult = rs.getString("level");
                        energy = " Уровень энергии: " + sResult;
                    }
                } finally {
                    try {
                        rs.close();
                    } catch (Exception ignore) {
                        ignore.printStackTrace();
                    }
                }
            } finally {
                try {
                    stmt.close();
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }
        } finally {
            try {
                conn.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        }
        conn.close();
        return energy;
    }

    //получение года и даты - самый корректный способ не ошибиться в локальном времени

    public static String getDT() throws Exception {
        String sResult = "";
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);
        String sTempDb = db_dir + "\\" + db_name2; 
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;
        int iTimeout = 30;

        String sMakeSelect = "SELECT strftime('%Y-%m-','now','localtime') as dt";

        Connection conn = DriverManager.getConnection(sDbUrl);
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.setQueryTimeout(iTimeout);
                ResultSet rs = stmt.executeQuery(sMakeSelect);
                try {
                    while (rs.next()) {
                        sResult = rs.getString("dt");
                    }
                } finally {
                    try {
                        rs.close();
                    } catch (Exception ignore) {
                        ignore.printStackTrace();
                    }
                }
            } finally {
                try {
                    stmt.close();
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }
        } finally {
            try {
                conn.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        }
        conn.close();
        return sResult;
    }

    //списание энергии

    public static void minusEnergy(String prog_type) throws Exception {
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);
        String sTempDb = db_dir + "\\" + db_name3; 
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;
        int iTimeout = 30;

        String p = "";
        if (prog_type == "A")
            p = "analyzer_cost";
        if (prog_type == "S")
            p = "stepler_cost";


        String sMakeSelect =
            " update energy set level = level -" + "(select param_value from parameters where param_name = '" + p +
            "' ) where type_prog = '" + prog_type + "'";
        // create a database connection
        Connection conn = DriverManager.getConnection(sDbUrl);
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.setQueryTimeout(iTimeout);
                stmt.executeUpdate(sMakeSelect);

            } finally {
                try {
                    stmt.close();
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }
        } finally {
            try {
                conn.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        }
        conn.close();

    }

    //запись действий в лог

    public static String writeLog(String flagCreateLogId, String note) throws Exception {
        String sResult = "";
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);
        String sTempDb = db_dir + "\\" + db_name2; 
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;
        int iTimeout = 30;
        int log_id;

        //получаем следующий айдишник
        if (flagCreateLogId == "Y") {
            log_id = getNextLogId();
        } else {
            log_id = 0;
        }

        String sMakeSelect =
            "insert into logs( note,dt_oper,log_id) " + "values(  '" + note + "', (SELECT datetime('now','localtime'))," +
            log_id + ")";

        // create a database connection
        Connection conn = DriverManager.getConnection(sDbUrl);
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.setQueryTimeout(iTimeout);
                stmt.executeUpdate(sMakeSelect);

            } finally {
                try {
                    stmt.close();
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }
        } finally {
            try {
                conn.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        }
        conn.close();
        return "" + log_id;
    }


    //получение следующего ид из логов

    public static int getNextLogId() throws Exception {
        int sResult;
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);
        String sTempDb = db_dir + "\\" + db_name2; 
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;
        int iTimeout = 30;

        String sMakeSelect = "select ifnull(max(log_id),0)+1 as id from logs ";

        Connection conn = DriverManager.getConnection(sDbUrl);
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.setQueryTimeout(iTimeout);
                ResultSet rs = stmt.executeQuery(sMakeSelect);
                sResult = rs.getInt("id");

            } finally {
                try {
                    stmt.close();
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }
        } finally {
            try {
                conn.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        }
        conn.close();
        return sResult;
    }

    //проверка существования кода в базе

    public static String checkQRcode(String p_id) throws Exception {
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);
        String sTempDb = db_dir + "\\" + db_name1; 
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;
        int iTimeout = 30;

        genom = "";

        String sMakeSelect = "SELECT count(*) as countt from genom WHERE obj_id = " + p_id + " Limit 10";

        Connection conn = DriverManager.getConnection(sDbUrl);
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.setQueryTimeout(iTimeout);
                ResultSet rs = stmt.executeQuery(sMakeSelect);
                try {
                    while (rs.next()) {

                        String sResult = rs.getString("countt");
                        // System.out.println(sResult);
                        genom = genom + sResult;


                    }
                } finally {
                    try {
                        rs.close();
                    } catch (Exception ignore) {
                        ignore.printStackTrace();
                    }
                }
            } finally {
                try {
                    stmt.close();
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }
        } finally {
            try {
                conn.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        }
        conn.close();
        return genom;
    }

    //анализатор

    public static String analyzer_main(String p_id, String dt_analiza) throws Exception {
        Date dt = new Date();
        String max_log_id = "";
        //int obj_id=0;
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);
        String sTempDb = db_dir + "\\" + db_name1; 
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;
        int iTimeout = 30;
        dt_analiza = getDT() + dt_analiza;


        genom = "";
        minusEnergy("A");

        String sMakeSelect =
            "SELECT g,obj_id,dt_change from genom WHERE obj_id = " + p_id + " and dt_change < '" + dt_analiza +
            "' order by dt_change desc Limit 1";

        Connection conn = DriverManager.getConnection(sDbUrl);
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.setQueryTimeout(iTimeout);
                ResultSet rs = stmt.executeQuery(sMakeSelect);
                try {
                    while (rs.next()) {
                        String sResult = rs.getString("g");
                        genom = genom + sResult;
                    }
                } finally {
                    try {
                        rs.close();
                    } catch (Exception ignore) {
                        ignore.printStackTrace();
                    }
                }
            } finally {
                try {
                    stmt.close();
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }
        } finally {
            try {
                conn.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        }
        conn.close();
        max_log_id = writeLog("Y", "анализ " + p_id + " на " + dt_analiza);

        //послезаписи логов прилепляем ID к результату
        genom = " № " + max_log_id + "\n" +
                " дата: " + dt.toString() + "\n" +
                "----------------------------------\n" +
                genom;

        return genom;
    }

    //степлер

    public static String stepler_main(String p_id1, String p_id2) throws Exception {

        int v_id1;
        int v_id2;
        genom = "НЕТ";
        String Letter1 = "";
        String Letter2 = "";
        String num1 = "";
        String num2 = "";
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);
        String sTempDb = db_dir + "\\" + db_name1; 
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;
        int iTimeout = 30;

        // списываем энергию. если уж дошло до обращения к базе
        minusEnergy("S");
        v_id1 = Integer.parseInt(p_id1);
        v_id2 = Integer.parseInt(p_id2);

        // create a database connection
        Connection conn = DriverManager.getConnection(sDbUrl);
        try {
            Statement stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            try {
                stmt.setQueryTimeout(iTimeout);
                stmt1.setQueryTimeout(iTimeout);

                ResultSet rs =
                    stmt.executeQuery("select ifnull(substr(type_for_stepler,1,2),0) as lett, ifnull(substr(type_for_stepler,3,1),0) as numm " +
                                      "from genom where obj_id = " + p_id1 + " Limit 1 ");
                ResultSet rs2 =
                    stmt1.executeQuery("select substr(type_for_stepler,1,2) as lett2, substr(type_for_stepler,3,1) as numm2 " +
                                       "from genom where obj_id = " + p_id2 + " Limit 1 ");
                try {
                    while (rs.next()) {

                        Letter1 = rs.getString("lett");
                        num1 = rs.getString("numm");

                    }

                    while (rs2.next()) {

                        Letter2 = rs2.getString("lett2");
                        num2 = rs2.getString("numm2");

                    }

                } finally {
                    try {
                        rs.close();
                        rs2.close();
                    } catch (Exception ignore) {
                        ignore.printStackTrace();
                    }
                }
            } finally {
                try {
                    stmt.close();
                    stmt1.close();
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }
        } finally {
            try {
                conn.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        }


        if (Letter1.equalsIgnoreCase(Letter2)) {
            if (!num1.equalsIgnoreCase(num2)) {
                genom = "ДА";
            }
        }
        conn.close();

        writeLog("N", "степлер " + p_id1 + " - " + p_id2 + " :результат - " + genom);

        return genom;

    }



    //анализатор мастерский

    public static String analyzer_master_main(String p_id, String dt_analiza) throws Exception {
        Date dt = new Date();
        String max_log_id = "";
        String sDriverName = "org.sqlite.JDBC";
        Class.forName(sDriverName);
        String sTempDb = db_dir + "\\" + db_name1; 
        String sJdbc = "jdbc:sqlite";
        String sDbUrl = sJdbc + ":" + sTempDb;
        int iTimeout = 30;
        dt_analiza = getDT() + dt_analiza;
        genom = "";

        String sMakeSelect =
            "SELECT g,obj_id,dt_change from genom WHERE obj_id = " + p_id + " and dt_change < '" + dt_analiza +
            "' order by dt_change desc Limit 1";

        Connection conn = DriverManager.getConnection(sDbUrl);
        try {
            Statement stmt = conn.createStatement();
            try {
                stmt.setQueryTimeout(iTimeout);
                ResultSet rs = stmt.executeQuery(sMakeSelect);
                try {
                    while (rs.next()) {

                        String sResult = rs.getString("g");
                        genom = genom + sResult;
                    }
                } finally {
                    try {
                        rs.close();
                    } catch (Exception ignore) {
                        ignore.printStackTrace();
                    }
                }
            } finally {
                try {
                    stmt.close();
                } catch (Exception ignore) {
                    ignore.printStackTrace();
                }
            }
        } finally {
            try {
                conn.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }
        }
        conn.close();
        //послезаписи логов прилепляем ID к результату
        genom = " № " + max_log_id + "\n" +
                "код: "+p_id +"\n" +
                " дата: " + dt.toString() + "\n" +
                "----------------------------------\n" +
                genom;

        return genom;
    }








}
