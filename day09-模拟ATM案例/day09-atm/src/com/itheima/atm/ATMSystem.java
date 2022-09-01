package com.itheima.atm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        // 需求：模拟ATM系统
        // 1.定义一个账户类
        // 2.定义一个ArrayList集合，用来存储系统的账户对象
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // 3.准备欢迎页
        while (true) {
            System.out.println("========欢迎你进入黑马ATM系统========");
            System.out.println("1.登录账户：");
            System.out.println("2.注册开户：");
            System.out.println("请您选择对应的功能（1/2）:");

            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    // 登录账户
                    login(accounts, scanner);
                    break;
                case 2:
                    // 注册开户
                    register(accounts, scanner);
                    break;
                default:
                    System.out.println("您输入的指令不存在，请重新输入：");
            }
        }

    }

    /**
     * 用户登录功能的实现
     * @param accounts 所有账户的集合
     * @param scanner  扫描器对象
     */
    private static void login(ArrayList<Account> accounts, Scanner scanner) {
        System.out.println("========欢迎你进入黑马ATM系统用户登录页面========");
        // 判断当前系统中有没有账户
        if (accounts.size() == 0) {
            System.out.println("当前系统中还没有账户，请先注册一个再回来登录吧");
            return;
        }

        // 1.让用户输入卡号
        while (true) {
            System.out.println("请您输入您的卡号:");
            String cardNo = scanner.next();
            // 2.根据卡号去账户集合中查询账户对象
            Account account = getAccountByCardNo(accounts, cardNo);

            if (account != null) {
                // 找到了
                while (true) {
                    System.out.println("请您输入您的密码：");
                    String password = scanner.next();
                    // 判断输入的密码是否正确
                    if (password.equals(account.getPassword())) {
                        // 密码输入正确
                        System.out.println("恭喜您，" + account.getUserName() + "登录成功！");
                        showUserCommands(accounts, account, scanner);
                        return;
                    } else {
                        System.out.println("对不起，您的密码输入错误，请重新输入：");
                    }
                }
            } else {
                System.out.println("您输入的卡号不存在，请重新输入：");
            }
        }

    }

    /**
     * 用户登录成功后的操作页
     * @param accounts
     * @param account
     * @param scanner   扫描器对象
     */
    private static void showUserCommands(ArrayList<Account> accounts, Account account, Scanner scanner) {
        while (true) {
            System.out.println("========欢迎你进入黑马ATM系统用户操作页面========");
            System.out.println("1.查询：");
            System.out.println("2.存款：");
            System.out.println("3.取款：");
            System.out.println("4.转账：");
            System.out.println("5.修改密码：");
            System.out.println("6.退出：");
            System.out.println("7.注销当前账户：");
            System.out.println("您可以选择功能进行操作了：");
            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    // 查询
                    queryAccountInfo(account);
                    break;
                case 2:
                    // 存款
                    deposit(account, scanner);
                    break;
                case 3:
                    // 取款
                    withdraw(account, scanner);
                    break;
                case 4:
                    // 转账
                    transfer(accounts, account, scanner);
                    break;
                case 5:
                    // 修改密码
                    updatePassword(account, scanner);
                    return;
                case 6:
                    // 退出
                    System.out.println("退出成功，欢迎您再次使用");
                    return;
                case 7:
                    // 注销当前账户
                    boolean result = deleteAccount(accounts, account, scanner);
                    if (result == true) {
                        // 删除了
                        return;
                    } else {
                        break;
                    }
                default:
                    System.out.println("您输入的命令有误，请您重新输入：");
            }
        }

    }

    /**
     * 注销账户功能的实现
     * @param accounts
     * @param account
     * @param scanner
     */
    private static boolean deleteAccount(ArrayList<Account> accounts, Account account, Scanner scanner) {
        while (true) {
            System.out.println("您确定要注销当前账户吗(y/n)？");
            String command = scanner.next();
            switch (command) {
                case "y":
                    // 删除
                    accounts.remove(account);
                    System.out.println("您的账户已注销");
                    return true;
                case "n":
                    // 不删除
                    System.out.println("好的，继续保留您的账户");
                    return false;
                default:
                    System.out.println("您输入的命令有误，请重新输入：");
            }
        }

    }

    /**
     * 修改密码功能的实现
     * @param account
     * @param scanner
     */
    private static void updatePassword(Account account, Scanner scanner) {
        System.out.println("========欢迎你进入黑马ATM系统修改密码页面========");
        while (true) {
            System.out.println("请您输入当前密码：");
            String password = scanner.next();
            // 判断用户输入的密码是否正确
            if (password.equals(account.getPassword())) {
                // 正确，可以修改
                while (true) {
                    System.out.println("请您输入新密码：");
                    String newPassword = scanner.next();
                    System.out.println("请您确认新密码：");
                    String reNewPassword = scanner.next();
                    // 判断两次输入是否一致
                    if (newPassword.equals(reNewPassword)) {
                        // 两次一样，可以修改
                        account.setPassword(newPassword);
                        System.out.println("密码修改成功，请重新登录！");
                        return;
                    } else {
                        System.out.println("您两次输入的密码不一致，请重新输入：");
                    }
                }
            } else {
                System.out.println("您输入的密码有误，请重新输入：");
            }
        }

    }

    /**
     * 用户转账功能的实现
     * @param accounts
     * @param account
     * @param scanner
     */
    private static void transfer(ArrayList<Account> accounts, Account account, Scanner scanner) {
        // 1.判断系统中是否有2个或2个以上的账户
        if (accounts.size() < 2) {
            System.out.println("当前系统中没有其他账户可以转账，请先注册一个再回来转账吧");
            return;
        }
        // 2.让用户输入一个转账金额
        System.out.println("请您输入转账金额：");
        double money = scanner.nextDouble();

        // 3.判断自己账户的钱是否够转账
        if (account.getBalance() < money) {
            System.out.println("您都没钱，就别转账了吧，还是先回去存一点钱再来转账吧");
            return;
        }

        // 4.钱够了
        // 5.输入对方卡号
        while (true) {
            System.out.println("请您输入对方卡号：");
            String targetCardNo = scanner.next();  // targetCardNo:目标卡号
            // 6.判断对方账户是否存在
            Account targetAccount = getAccountByCardNo(accounts, targetCardNo);
            // 7.判断目标账户是否存在
            if (targetAccount == null) {
                System.out.println("您输入的卡号有误，请您重新输入：");
                continue;
            }
            // 目标账户存在
            // 判断是否是给自己转账
            if (account == targetAccount) {
                System.out.println("您不能给自己转账，请您重新输入一个卡号：");
                continue;
            }
            // 可以转账了
            String targetUserName = targetAccount.getUserName();
            String tip = "*" + targetUserName.substring(1); // *晓明
            for (int i = 0; i < 3; i++) {
                System.out.println("请您输入" + tip + "的姓氏：");
                String surName = scanner.next();    // surName, 姓氏
                if (surName.equals(targetUserName.substring(0, 1))) {
                    // 姓氏输入正确，可以转账
                    account.setBalance(account.getBalance() - money);
                    targetAccount.setBalance(targetAccount.getBalance() + money);
                    System.out.println("您成功转账：" + money + "元");
                    return;
                } else {
                    System.out.println("您输入的姓氏不正确，您还有" + (2 - i) + "次机会");
                }
            }
        }

    }

    /**
     * 用户取款功能的实现
     * @param account
     * @param scanner
     */
    private static void withdraw(Account account, Scanner scanner) {
        System.out.println("========欢迎你进入黑马ATM系统取款页面========");
        // 1.判断余额是否大于等于100
        if (account.getBalance() < 100) {
            System.out.println("您账户中的余额小于100元，不能取款，先去存点钱吧");
            return;
        }
        // 账户余额大于100
        // 2.让用户输入取款金额
        while (true) {
            System.out.println("请您输入取款金额：");
            double money = scanner.nextDouble();

            // 3.判断取款金额是否超过当次限额
            if (money > account.getQuota()) {
                // 超过了当次限额
                System.out.println("您的取款金额超过了当次取款限额，您每次最多取：" + account.getQuota() + "元");
                continue;
            }

            // 4.判断取款金额是否超过账户余额
            if (money > account.getBalance()) {
                System.out.println("您没有这么多钱可以取，您最多取：" + account.getBalance() + "元");
                continue;
            }

            // 可以取款了
            account.setBalance(account.getBalance() - money);
            System.out.println("恭喜您，取款：" + money + "成功");

            queryAccountInfo(account);
            return;
        }

    }

    /**
     * 用户存款功能的实现
     * @param account
     * @param scanner
     */
    private static void deposit(Account account, Scanner scanner) {
        System.out.println("========欢迎你进入黑马ATM系统存款页面========");
        System.out.println("请您输入存款金额：");
        double money = scanner.nextDouble();
        // 修改最终的账户余额
        account.setBalance(account.getBalance() + money);
        // 展示一下最终的账户信息
        queryAccountInfo(account);
    }

    /**
     * 展示账户信息功能
     * @param account
     */
    private static void queryAccountInfo(Account account) {
        System.out.println("========欢迎你进入黑马ATM系统查询页面========");
        System.out.println("卡号：" + account.getCardNo());
        System.out.println("户主：" + account.getUserName());
        System.out.println("余额：" + account.getBalance());
        System.out.println("当次取款限额：" + account.getQuota());
    }

    /**
     * 根据卡号去账户集合中查找账户
     * @param accounts  所有账户的集合
     * @param cardNo    要查找的卡号
     * @return  返回的结果
     */
    private static Account getAccountByCardNo(ArrayList<Account> accounts, String cardNo) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getCardNo().equals(cardNo)) {
                // 找到了
                return accounts.get(i);
            }
        }
        // 没找到
        return null;
    }

    /**
     * 用户开户功能的实现
      * @param accounts 所有账户的集合
     */
    private static void register(ArrayList<Account> accounts, Scanner scanner) {
        System.out.println("========欢迎你进入黑马ATM系统用户开户页面========");
        // 1.创建一个Account对象，用来封装账户信息
        Account account = new Account();
        // 2.键盘录入姓名、密码、确认密码、当次取款限额
        System.out.println("请输入您的姓名：");
        String userName = scanner.next();
        account.setUserName(userName);

        while (true) {
            System.out.println("请输入您的密码：");
            String password = scanner.next();
            System.out.println("请再次输入您的密码：");
            String rePassword = scanner.next();
            // 3.判断两次输入密码是否一致
            if (password.equals(rePassword)) {
                // 两次输入一致，可以用了
                account.setPassword(password);
                break;
            } else {
                System.out.println("您两次输入的密码不一致，请重新输入：");
            }
        }

        System.out.println("请输入当次取款限额：");
        double quota = scanner.nextDouble();
        account.setQuota(quota);

        // 4.随机生成一个不重复的8位数字的卡号
        while (true) {
            String cardNo = "";
            Random random = new Random();
            for (int i = 0; i < 8; i++) {
                cardNo += random.nextInt(10);
            }

            // 5.判断生成的卡号是否重复
//            boolean flag = true;    // 先认为卡号不重复
//            for (int i = 0; i < accounts.size(); i++) {
//                if (accounts.get(i).getCardNo().equals(cardNo)) {
//                    // 重复
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                // 不重复
//                account.setCardNo(cardNo);
//                break;
//            }

            Account account1 = getAccountByCardNo(accounts, cardNo);
            if (account1 == null) {
                // 卡号不重复
                account.setCardNo(cardNo);
                break;
            }
        }
        System.out.println("恭喜您：" + userName + "开户成功，您的卡号是：" + account.getCardNo() + ", 请妥善保管");
        // 6.把生成的账户对象放入到账户集合中去
        accounts.add(account);
    }
}
