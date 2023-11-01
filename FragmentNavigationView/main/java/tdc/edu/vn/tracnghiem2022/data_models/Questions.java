package tdc.edu.vn.tracnghiem2022.data_models;

import java.util.ArrayList;

public class Questions {
    public static boolean state = false;
    public static ArrayList<AbstractQuestion> questions;
    public static void init(){
        questions= new ArrayList<>();
        //Create the question
        MultiQuetionMultiChoices question1 = new MultiQuetionMultiChoices();
        question1.setQuestionDescription("Trong các mô hình mạng dưới đây, mô hình nào được dùng phổ biến hiện nay:");
        question1.setQuetionChoices("A. Peer - to – Peer","B. Remote Access","C. Terminal Mainframe","D. Client – Server");
        question1.setQuestionCorrect(0,3);
        questions.add(question1);


        MultiQuestionOneChoices question2 = new MultiQuestionOneChoices();
        question2.setQuestionDescription("Dịch vụ mạng DNS dùng để làm gì?");
        question2.setQuetionChoices("A. Cấp địa chỉ cho các máy trạm","B. Phân giải tên miền và địa chỉ IP","C. Truyền file và dữ liệu","D. Gửi thư điện tử");
        question2.setQuestionCorrect(1);
        questions.add(question2);

        MatchingQuestion question3 = new MatchingQuestion();
        question3.setQuestionDescription("Hãy tìm những đáp án đúng cho các mệnh đề dưới đây bằng cách nhấp chọn ô xổ xuống bên tay phải và lựa chọn câu trả lời:");
        question3.setQuetionChoicesA("A. Giao thức DHCP có thể cấp được...","B. Mô hình mạng dùng nhiều nhất...","C. Dịch vụ DNS dùng để ...");
        question3.setQuetionChoicesB("1. Địa chỉ Mac","2. Địa chỉ IP","3. Subnet Mask","4. Client – Server","5. Phân giải tên và địa chỉ");
        question3.setQuestionCorrect(1,3,4);
        questions.add(question3);

        TrueFalseQuestion question4 = new TrueFalseQuestion();
        question4.setQuestionDescription("Hãy lựa chọn ĐÚNG hay SAI cho những mệnh đề dưới đây bằng cách nhấp chuột vào nút bên tay phải:");
        question4.setQuetionChoices("A. Giao thức DHCP có thể cấp được địa chỉ IP","B. Mô hình mạng phổ biến: Terminal – Mainframe","C. Dịch vụ DNS dùng để phân giải tên và địa chỉ");
        question4.setQuestionCorrect(1,0,1);
        questions.add(question4);

        TrueFalseQuestion question5 = new TrueFalseQuestion();
        question5.setQuestionDescription("Hãy lựa chọn ĐÚNG hay SAI cho những mệnh đề dưới đây bằng cách kéo thanh trượt bên tay phải:");
        question5.setQuetionChoices("A. Mô hình mạng phổ biến: Terminal – Mainframe","B. Giao thức DHCP có thể cấp được địa chỉ IP","C. Dịch vụ DNS dùng để phân giải tên và địa chỉ");
        question5.setQuestionCorrect(0,1,1);
        questions.add(question5);
//
//        MultiQuetionMultiChoices question6 = new MultiQuetionMultiChoices();
//        question6.setQuestionDescription("Trong các mô hình mạng dưới đây, mô hình nào được dùng phổ biến hiện nay:");
//        question6.setQuetionChoices("A. Peer - to – Peer","B. Remote Access","C. Terminal Mainframe","D. Client – Server");
//        question6.setQuestionCorrect(0,3);
//        questions.add(question6);

//
//        MultiQuestionOneChoices question7 = new MultiQuestionOneChoices();
//        question7.setQuestionDescription("Dịch vụ mạng DNS dùng để làm gì?");
//        question7.setQuetionChoices("A. Cấp địa chỉ cho các máy trạm","B. Phân giải tên miền và địa chỉ IP","C. Truyền file và dữ liệu","D. Gửi thư điện tử");
//        question7.setQuestionCorrect(1);
//        questions.add(question7);
    }
}
