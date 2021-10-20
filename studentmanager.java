import java.util.ArrayList;
import java.util.Scanner;

public class studentmanager {
    public static void main(String[] args)
    {
        ArrayList<student> array = new ArrayList<student>();
        while(true)
        {
            System.out.println("--------欢迎使用学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看所有学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            
            switch (choose) {
                case 1:
                    addStudent(array);
                    break;
                case 2:
                    deleteStudent(array);
                    break;
                case 3:
                    updateStudent(array);
                    break;
                case 4:
                    findAllStudent(array);
                    break;
                case 5:
                    System.out.println("谢谢使用");
                    System.exit(0);
            }
        }
    }
    public static void addStudent(ArrayList<student> array){
        String sid;
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("请输入学生学号：");
            sid = sc.nextLine();
            boolean flag = isUsed(array,sid);
            if(flag)
            {
                System.out.println("你输入的学号已经被使用，请重新输入");
            }
            else
            {
                break;
            }
        }
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生地址：");
        String address = sc.nextLine();

        student s = new student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        array.add(s);
        System.out.println("添加学生成功");
    }

    public static boolean isUsed(ArrayList<student> array,String sid){
        boolean flag = false;

        for(int i=0;i<array.size();i++)
        {
            student s = array.get(i);
            if(s.getSid().equals(sid))
            {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void findAllStudent(ArrayList<student> array){
        if(array.size()==0)
        {
            System.out.println("无信息，请先添加信息再查询");
        }
        else
        {
            System.out.println("学号\t\t姓名\t\t年龄\t\t居住地");
            for(int i=0;i<array.size();i++)
            {
                student s = array.get(i);
                System.out.println(s.getSid()+"\t\t"+s.getName()+"\t\t"+s.getAge()+"岁\t\t"+s.getAddress());
            }
        }
    }

    public static void deleteStudent(ArrayList<student> array){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要删除的学生的学号：");
        String sid = sc.nextLine();
        int index = -1;
        for(int i=0;i<array.size();i++)
        {
            student s = array.get(i);
            if(s.getSid().equals(sid))
            {
                index = i;
                break;
            }
        }
        if(index==-1)
        {
            System.out.println("该信息不存在，请重新输入");
        }
        else
        {
            array.remove(index);
            System.out.println("删除学生成功");
        }
    }

    public static void updateStudent(ArrayList<student> array){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要修改的学生的学号：");
        String sid = sc.nextLine();
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地址：");
        String address = sc.nextLine();
        for(int i=0;i<array.size();i++)
        {
            student stu = array.get(i);
            if(stu.getSid().equals(sid))
            {
                stu.setName(name);
                stu.setAge(age);
                stu.setAddress(address);
                break;
            }
        }
        System.out.println("修改学生成功");
    }
}
