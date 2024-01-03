package co.edu.sena.peluqueriaalejandra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

// para que una actividad puede hacer una  actividad debe heredar de una de las  diferentes clases activity que existen, en este caso esta actividad hereda de AppCompatActivity
class WelcomeActivity : AppCompatActivity() {
    // un método que no puede faltar en ninguna actividad es onCreate, la cual es donde se carga y donde se crea la actividad para poder ser mostrada
    override fun onCreate(savedInstanceState: Bundle?) {
        // la primera línea de esta función siempre es un llamado al método onCreate de la clase padre, por eso la palabra super
        super.onCreate(savedInstanceState)

        //este método setContentView se encarga de cargar el diseño o el xml que nosotros hayamos destinado para esa actividad,
        // entonces debemos asegurarnos de que a quien estemos llamando el layout que corresponde en este caso a activity_welcome
        setContentView(R.layout.activity_welcome)
    }

    fun onHistory (view: View) {
        val intent = Intent(this, HistoryActivity::class.java)
        startActivity(intent)
    }

    fun onAppointment(view: View) {
        val intent = Intent(this, AppointmentActivity::class.java)
        startActivity(intent)
    }
    fun onProfile(view: View) {}
}