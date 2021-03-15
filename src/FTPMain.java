import com.wang.test.FtpTest;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;

public class FTPMain {

    /**
     * 获取FTPClient对象
     *
     * @param ftpHost     FTP主机服务器
     * @param ftpPassword FTP 登录密码
     * @param ftpUserName FTP登录用户名
     * @param ftpPort     FTP端口 默认为21
     * @return
     */
    private static FTPClient getFTPClient(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(ftpHost, ftpPort);              // 连接FTP服务器
            ftpClient.login(ftpUserName, ftpPassword);        // 登陆FTP服务器
            ftpClient.setControlEncoding("UTF-8");             // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                System.out.println("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
                System.out.println("FTP连接成功。");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FTP的端口错误,请正确配置。");
        }
        return ftpClient;
    }

    /*
     * 从FTP服务器下载文件
     * @param ftpHost             FTP IP地址
     * @param ftpUserName         FTP 用户名
     * @param ftpPassword         FTP用户名密码
     * @param ftpPort             FTP端口
     * @param ftpPath             FTP服务器中文件所在路径 格式： ftptest/aa
     * @param localPath           下载到本地的位置 格式：H:/download
     * @param fileName            FTP服务器上要下载的文件名称
     * @param targetFileName      FTP服务器上要下载的文件名称
     */
    private static void downloadFtpFile(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort, String ftpPath, String localPath, String fileName, String targetFileName) {

        FTPClient ftpClient = null;
        try {
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.changeWorkingDirectory(ftpPath);

            String f_ame = new String(fileName.getBytes("GBK"), FTP.DEFAULT_CONTROL_ENCODING);    //编码文件格式,解决中文文件名

            File localFile = new File(localPath + File.separatorChar + targetFileName);
            OutputStream os = new FileOutputStream(localFile);
            ftpClient.retrieveFile(f_ame, os);
            os.close();
            ftpClient.logout();

        } catch (FileNotFoundException e) {
            System.out.println("没有找到" + ftpPath + "文件");
            e.printStackTrace();
        } catch (SocketException e) {
            System.out.println("连接FTP失败.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件读取错误。");
            e.printStackTrace();
        }
    }

    /**
     * Description:             向FTP服务器上传文件
     *
     * @param filename 上传到FTP服务器上的文件名
     * @param input    输入流
     * @return 成功返回true，否则返回false
     */
    private static boolean uploadFile(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort, String ftpPath, String filename, InputStream input) {
        boolean result = false;
        FTPClient ftpClient = new FTPClient();
        try {
            int reply;
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.changeWorkingDirectory(ftpPath);

            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                return result;
            }

            filename = new String(filename.getBytes("GBK"), FTP.DEFAULT_CONTROL_ENCODING);    //编码文件名，支持中文文件名
            //上传文件
            if (!ftpClient.storeFile(filename, input)) {
                return result;
            }
            input.close();
            ftpClient.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] test = {"/Users/xiangxianwen/JobProjcet/ehrs/release/apk/ehr_v4.0.0_201208420_release_EB001.apk"};
        push(test);

          testMethod("1");



    }

    public static  <T> T testMethod(T t) {

        return t;
    }


    public static void push(String[] args) {
        String ftpHost = "123.59.41.214";
        String ftpUserName = "wangjianjun";
        String ftpPassword = "7FZ3!C0qio";
        int ftpPort = 18121;
        String ftpPath = "/app/ehr/4.0.0/";

        if (args.length > 0) {
            try {
                String fileName = args[0];
                if (args.length > 1) {
                    ftpPath = args[1];
                }
                File file = new File(fileName);
                FileInputStream in = new FileInputStream(file);
                uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, file.getName(), in);
                System.out.println("上传 " + file.getName() + " 到ftp成功，路径：" + ftpPath + file.getName());
                System.out.println("上传地址: http://cdn.android.2haohr.com/app/ehr/4.0.0/ehr_v4.0.0_201208420_release_EB001.apk");
//                  FtpTest.downloadFtpFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, "E:\\", "test_通知_4724.docx", "测试下载文件.docx");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("请传入apk路径参数，示例：\njava -jar .\\ftp_apk.jar D:\\temp\\test.apk\n[参数2可选：ftp路径，默认：/app/ehr/DailyCompiled/]");
        }

    }
}
