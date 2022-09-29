package com.example.indianconstitution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.indianconstitution.databinding.ActivityQuizstartBinding;
import com.example.indianconstitution.model.question;
import com.google.android.material.snackbar.Snackbar;

public class quizstart extends AppCompatActivity {
    private ActivityQuizstartBinding binding;
    int current=0;
    int prg=10;
    private question[] bank= new question[]{

            new question(R.string.question1,true),
            new question(R.string.question2,false),
            new question(R.string.question3,true),
            new question(R.string.question4,false),
            new question(R.string.question5,false),
            new question(R.string.question6,true),
            new question(R.string.question7,true),
            new question(R.string.question8,false),
            new question(R.string.question9,false),
            new question(R.string.question10,true)


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_quizstart);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_quizstart);
        getWindow().setStatusBarColor(ContextCompat.getColor(quizstart.this,R.color.black));
        binding.textView2.setText(bank[current].getQuestionid());

        //here we increment the progress bar with 10% for the first que.
        binding.indicator.setProgress(prg);
        binding.percent.setText(prg+"%");

        //LISTENER FOR NEXT BTN
        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((prg+10)<=100){
                prg=(prg+10);}
                else{prg=10;}
                binding.percent.setText(prg+"%");
                binding.indicator.setProgress(prg);
                current=(current+1)%bank.length;
                binding.textView2.setText(bank[current].getQuestionid());

            }
        });

        //LISTENER FOR PREVIOUS BTN
        binding.prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current>0){
                    prg=prg-10;
                    binding.percent.setText(prg+"%");
                    binding.indicator.setProgress(prg);
                current=(current-1)%bank.length;}
                binding.textView2.setText(bank[current].getQuestionid());
            }
        });


        //LISTENER IF TRUE BTN
        binding.truebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkans(true);
            }
        });

        //LISTENER FOR FALSE BTN
        binding.falsebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkans(false);
            }
        });
    }


    //METHOD FOR CHECKING IF THE ANSWER IS TRUE OR NOT;
    private void checkans(boolean btn ) {
        int msgid;
        if(btn==bank[current].isIstrue()){
            msgid=R.string.correct;
        }else{
            msgid=R.string.incorrect;
        }
        Snackbar.make(binding.textView2,msgid,Snackbar.LENGTH_SHORT).show();
    }

}