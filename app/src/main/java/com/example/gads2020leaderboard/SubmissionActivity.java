package com.example.gads2020leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gads2020leaderboard.Interface.RetrofitService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SubmissionActivity extends AppCompatActivity {

    private Dialog submissionDialog;
    private TextView yesTv, questionTV,success, notSuccessful;
    private ImageView closePopUp, successfulSubmission, unsuccessfulSubmission;

    private TextView submitBtn;

    private static Retrofit.Builder builder= new Retrofit.Builder()
            .baseUrl("https://docs.google.com/forms/d/e/")
            .addConverterFactory(GsonConverterFactory.create());

    public static Retrofit retrofit = builder.build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        submissionDialog = new Dialog(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        submitBtn = findViewById(R.id.submit_txt);

        final EditText firstName = (EditText) findViewById(R.id.first_name);
        final EditText lastName = (EditText) findViewById(R.id.last_name);
        final EditText email = (EditText) findViewById(R.id.email_address);
        final EditText Link = (EditText) findViewById(R.id.project_link);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShowQuestionDialog();
            }
            private void ShowQuestionDialog() {
                submissionDialog.setContentView(R.layout.question_dialog);
                closePopUp = (ImageView) submissionDialog.findViewById(R.id.close_popup);
                yesTv = (TextView)submissionDialog.findViewById(R.id.yes_txt);
                questionTV = (TextView) submissionDialog.findViewById(R.id.question_txt);

                yesTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        executeSendFeedbackForm(
                                firstName.getText().toString(),
                                lastName.getText().toString(),
                                email.getText().toString(),
                                Link.getText().toString()
                        );

                    }
                });
                closePopUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        submissionDialog.dismiss();
                    }
                });
                submissionDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                submissionDialog.show();

            }
        });

    }



    private void executeSendFeedbackForm(String firstName,String lastName, String email, String Link) {
        RetrofitService userClient = retrofit.create(RetrofitService.class);

        Call<ResponseBody> call = userClient.createPost(
            firstName,
            lastName,
            email,
            Link
        );
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                submissionDialog.setContentView(R.layout.successful_alert);
                successfulSubmission = (ImageView) submissionDialog.findViewById(R.id.successful_popup);
                success= (TextView)submissionDialog.findViewById(R.id.successful_txt);
                submissionDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                submissionDialog.show();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                submissionDialog.setContentView(R.layout.not_successful_alert);
                unsuccessfulSubmission = (ImageView) submissionDialog.findViewById(R.id.not_successful_popup);
                notSuccessful= (TextView)submissionDialog.findViewById(R.id.not_successful_txt);
                submissionDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                submissionDialog.show();

            }
        });
    }


}
