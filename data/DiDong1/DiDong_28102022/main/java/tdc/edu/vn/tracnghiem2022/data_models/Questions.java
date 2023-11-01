package tdc.edu.vn.tracnghiem2022.data_models;

import java.util.ArrayList;

public class Questions {
    public static ArrayList<AbtracQuestion> questions;

    public static void init(){
        questions = new ArrayList<AbtracQuestion>();
        MultiQuestionMultiChoices question1 = new MultiQuestionMultiChoices();
        question1.setQuesionDescription("Trong các mô hình mạng dưới đây, mô hình nào được dùng phổ biến hiện nay:");
        question1.setQuestionChoices("Peer - to – Peer","Remote Access","Terminal Mainframe","Client – Server");
        question1.setQuestionCorrects(0,3);
        questions.add(question1);

        MutilQuestionOneChoice question2 = new MutilQuestionOneChoice();
        question2.setQuesionDescription("Dịch vụ mạng DNS dùng để làm gì?");
        question2.setQuestionChoices("Cấp địa chỉ cho các máy trạm","Phân giải tên miền và địa chỉ IP","Truyền file và dữ liệu","Gửi thư điện tử");
        question2.setQuestionCorrects(1);



    }

}
