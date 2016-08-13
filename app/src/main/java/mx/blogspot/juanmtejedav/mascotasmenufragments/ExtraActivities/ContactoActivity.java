package mx.blogspot.juanmtejedav.mascotasmenufragments.ExtraActivities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import mx.blogspot.juanmtejedav.mascotasmenufragments.R;

/**
 * Created by juantejeda1 on 12/08/16.
 */
public class ContactoActivity extends AppCompatActivity{

    String emisor, email, mensaje;
    EditText etEmisor, etEmail, etMensaje;
    Session session;
    ProgressDialog progressDialog;
    String rec = "correo_receptor@gmail.com";
    String passwordEmisor = "****";
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        initIds();

        toolbar = (Toolbar) findViewById(R.id.toolDetalle2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void initIds() {
        etEmisor = (EditText) findViewById(R.id.ET_nombreCompleto);
        etEmail = (EditText) findViewById(R.id.ET_email);
        etMensaje = (EditText) findViewById(R.id.ET_mensaje);
    }

    public void enviarComentario(View v){
        emisor = etEmisor.getText().toString();
        mensaje = etMensaje.getText().toString();
        email = etEmail.getText().toString();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //return super.getPasswordAuthentication();
                return new PasswordAuthentication(emisor, passwordEmisor);
            }
        });

        progressDialog = ProgressDialog.show(this, "", "Sending Mail...", true);

        RetrieveFeedTask task = new RetrieveFeedTask();
        task.execute();

       /* Mail To with Intent
       Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL, "dummy@gmail.com");
        i.putExtra(Intent.EXTRA_SUBJECT, "Contacto a desarrollador de Mascotas");
        i.putExtra(Intent.EXTRA_EMAIL, "dummy@gmail.com");
        */
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    class RetrieveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));
                message.setSubject("Cliente: " + emisor);
                message.setContent(mensaje, "text/html; charset=utf-8");
                Transport.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
        }
    }

}
