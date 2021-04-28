package br.saojudas.sdm21_1.meuprimeiroappdiv1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarMensagem(View view) {
        //referência para o campo em que o usuário digita
        EditText mensagemEditText = findViewById(R.id.mensagemEditText);

        //mensagem digitada pelo usuário
        String mensagem = mensagemEditText.getEditableText().toString();

        //intent a ser enviado ao SO, a princípio vazio
        Intent enviarMEnsagemIntent = new Intent();

        //a ação desejada é SEND, que representa compartilhar conteúdo
        enviarMEnsagemIntent.setAction(Intent.ACTION_SEND);

        //tipo do conteúdo manipulado especificado em um MIME type
        enviarMEnsagemIntent.setType("text/plain");

        //mensagem vai dentro do Intent associada à chave EXTRA_TEXT
        //para que possa ser pega pela próxima Activity que irá receber
        //o Intent
        enviarMEnsagemIntent.putExtra(Intent.EXTRA_TEXT, mensagem);

        //construimos um Intent que empacota o atual e garante
        //que a tela de escolha do app sempre apareça e que o usuário
        //não possa selecionar o app padrão
        enviarMEnsagemIntent = Intent.createChooser(enviarMEnsagemIntent, null);

        //envia Intent para o Android
        //qualquer Activitt (até de outros apps) que, em tempo de instalaçãp
        //tiver especificado ser capaz de atender requisições cuja ACTION seja
        //ACTION_SEND será considerada apta pelo Android
        startActivity(enviarMEnsagemIntent);

    }
}













