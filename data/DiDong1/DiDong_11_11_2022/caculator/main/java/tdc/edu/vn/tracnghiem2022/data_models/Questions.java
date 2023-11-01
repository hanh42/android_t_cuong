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
        questions.add(question2);

        MatchingQuestion question3 = new MatchingQuestion();
        question3.setQuesionDescription(
                "Hãy tìm những đáp án đúng cho các mệnh đề dưới đây bằng cách nhấp chọn ô xổ xuống bên tay phải và lựa chọn câu trả lời:");
        question3.setQuestionChoicesA("Giao thức DHCP có thể cấp được...","Mô hình mạng dùng nhiều nhất...","Dịch vụ DNS dùng để ...");
        question3.setQuestionChoicesB("Địa chỉ Mac","Địa chỉ IP"," Subnet Mask","Client – Server","Phân giải tên và địa chỉ");
        question3.setQuestionCorrects(1,3,4);
        questions.add(question3);

        TrueFalseQuestion question4 = new TrueFalseQuestion();
        question4.setQuesionDescription("Hãy lựa chọn ĐÚNG hay SAI cho những mệnh đề dưới đây bằng cách nhấp chuột vào nút bên tay phải:");
        question4.setQuestionChoices("Giao thức DHCP có thể cấp được địa chỉ IP",". Mô hình mạng phổ biến: Terminal – Mainframe","Dịch vụ DNS dùng để phân giải tên và địa chỉ");
        question4.setQuestionCorrects(1,0,1);
        questions.add(question4);

        TrueFalseQuestion question5 = new TrueFalseQuestion();
        question5.setQuesionDescription("Hãy lựa chọn ĐÚNG hay SAI cho những mệnh đề dưới đây bằng cách kéo thanh trượt bên tay phải");
        question5.setQuestionChoices("Mô hình mạng phổ biến: Terminal – Mainframe","Giao thức DHCP có thể cấp được địa chỉ IP",". Dịch vụ DNS dùng để phân giải tên và địa chỉ");
        question5.setQuestionCorrects(0,1,1);
        questions.add(question5);



    }

}
