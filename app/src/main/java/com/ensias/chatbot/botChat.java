package com.ensias.chatbot;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.concurrent.TimeUnit;

public class botChat extends AppCompatActivity {

    private EditText usermessage;
    private Button sendmessage;
    private static  MessageAdapter messageAdapter;
    private static ListView messagesView;
    public static TextView istyping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bot_chat);
        messageAdapter = new MessageAdapter(this);
        messagesView = (ListView) findViewById(R.id.messages_view);
        messagesView.setAdapter(messageAdapter);
        usermessage = findViewById(R.id.editText);
        sendmessage = findViewById(R.id.sendmessage);
        istyping = (TextView)findViewById(R.id.istyping);
        istyping.setVisibility(View.INVISIBLE);
        sendmessage.setEnabled(false);
        usermessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              if(usermessage.getText().length() != 0)
                  sendmessage.setEnabled(true);
              else
                  sendmessage.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        sendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendMessage(true, String.valueOf(usermessage.getText()));
                usermessage.getText().clear();


            }
        });
        istyping.setVisibility(View.VISIBLE);
        TimeWaiter.addNext(new Runnable() {
            @Override
            public void run() {
              StartingApp();
            }
        }, 2, TimeUnit.SECONDS, TimeWaiter.DataType.BOT);

    }
    public void StartingApp(){
        try{
            istyping.setVisibility(View.VISIBLE);
                    botChat.this.onMessage("✋ Bonjour "+MainActivity.username.getText()+" sur notre assisstance en-ligne. Je suis un vérificateur automatique des symptômes.", false);
                    Thread.sleep(2300);
                    botChat.this.onMessage("Ce service est à titre informatif et n'est pas un avis médical qualifié.", false);
                     Thread.sleep(2300);
                    botChat.this.onMessage( "En cas d'urgence sanitaire, appelez immédiatement votre numéro d'urgence local.", false);
            Thread.sleep(2300);
            botChat.this.onMessage( "Avant de commencer, nous considérons que vous avez lu et compris nos Termes et Conditions.", false);
            openDialog();
            Thread.sleep(2300);
            botChat.this.onMessage( "Bon "+MainActivity.username.getText()+", pouvez vous me citez vos symptomes?.", false);
            istyping.setVisibility(View.INVISIBLE);
                    BotData.RESET();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void openDialog() {
        TermsAndConditions exampleDialog = new TermsAndConditions();
        exampleDialog.show(getSupportFragmentManager(), "Terms nd Conditions");
    }

    public void onMessage(String str, Boolean isUser) {
        final ObjectMapper mapper = new ObjectMapper();
        final Message message = new Message(str, isUser);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageAdapter.add(message);
                messagesView.setSelection(messagesView.getCount() - 1);
            }
        });
    }


    public void SendMessage(boolean isUser, String str){
        if(isUser) {
            //BotData.RESET();
            onMessage(str, true);
        }
        /** Bot answer **/
       final  String answer = BotData.GetBestAnswer(str);
        istyping.setVisibility(View.VISIBLE);
        TimeWaiter.addNext(new Runnable() {
            @Override
            public void run() {
                botChat.this.onMessage(answer, false);
                istyping.setVisibility(View.INVISIBLE);
                BotData.RESET();
            }
        }, 3, TimeUnit.SECONDS, TimeWaiter.DataType.BOT);

        BotData.RESET();

    }
}