package interview;

import java.util.ArrayList;

public class Interview {
    ArrayList<Question> questions;
    
    Interview(){
        questions=new ArrayList<>();
    }
    
    void addQuestion(Question question){
        this.questions.add(question);
    }
}
