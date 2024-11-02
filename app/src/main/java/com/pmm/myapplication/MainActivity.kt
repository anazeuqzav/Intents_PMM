package com.pmm.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botones
        val setCallButton = findViewById<AppCompatButton>(R.id.btnCall)
        val setAlarmButton = findViewById<AppCompatButton>(R.id.btnAlarm)
        val setUrlButton = findViewById<AppCompatButton>(R.id.btnUrl)
        val setSmsButton = findViewById<AppCompatButton>(R.id.btnSms)

        /**
         * Botón de llamada. Abre el marcador con el número de telefono indicado pero no inicia
         * la llamada automáticamente. El usuario debe presionar el botón de llamada para iniciar
         * la llamada.
         */
        setCallButton.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:999999999")
            }
            startActivity(callIntent)
        }

        /**
         * Botón de Alarma. Abre la aplicación de la alarma (si existe) y configura una alarma
         * para la hora indicada.
         */
        setAlarmButton.setOnClickListener {
            val alarmIntent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_HOUR, 9) // Hora de la alarma
                putExtra(AlarmClock.EXTRA_MINUTES, 30) // Minutos de la alarma
                putExtra(AlarmClock.EXTRA_MESSAGE, "A trabajar!") // Mensaje opcional para la alarma
            }
            startActivity(alarmIntent)

        }

        /**
         * Botón visitar página web. Abre un navegador y visita la página webn indicada
         */
        setUrlButton.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.iesvirgendelcarmen.com/")  // URL
            }
            startActivity(urlIntent)
        }

        /**
         * Botón que abre la aplicación de mensajes y envía un sms con un mensaje configurado
         * al telefóno indicando.
         */
        setSmsButton.setOnClickListener {
            val smsIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("sms:123456789")  // Número de teléfono
                putExtra("sms_body", "Mensaje de prueba") // Mensaje
            }
            startActivity(smsIntent)
        }

    }
}


