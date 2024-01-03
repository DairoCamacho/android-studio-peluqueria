package co.edu.sena.peluqueriaalejandra

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class RegistrationActivity : AppCompatActivity() {
    // creamos las referencias de los objetos con los que vamos a interactuar y les asignamos un valor inicial Nulo
    private var edtRegFirstName: EditText? = null
    private var edtRegLastName: EditText? = null
    private var edtRegBirthday: EditText? = null
    private var edtRegMobileNumber: EditText? = null
    private var edtRegEmail: EditText? = null
    private var edtPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        /*
        // Obtener los EditText desde la vista buscandolos por sus IDs
        val et_reg_first_name = findViewById<EditText>(R.id.et_reg_first_name)
        val et_reg_last_name = findViewById<EditText>(R.id.et_reg_last_name)
        val et_reg_mobile_number = findViewById<EditText>(R.id.et_reg_mobile_number)
        val et_reg_email = findViewById<EditText>(R.id.et_reg_email)
        val et_reg_password = findViewById<EditText>(R.id.et_reg_password)
        */
    }

    fun onSigUp(view: View) {
        // Obtener los EditText desde la vista buscandolos por sus IDs
        // y agrupamos todos los EditText dentro de un Array
        val arrayEditText = arrayOf<EditText>(
            findViewById(R.id.et_reg_first_name),
            findViewById(R.id.et_reg_last_name),
            findViewById(R.id.et_reg_mobile_number),
            findViewById(R.id.et_reg_email),
            findViewById(R.id.et_reg_password)
        )

        // Creamos una variable booleana para indicar si todos los campos están llenos
        var allFieldsFilled = true

        /*
        Recorremos el array con un bucle for para verificar si el texto es nulo o vacío,
        usando el método isNullOrEmpty() de la clase String,
        que devuelve true si el texto es nulo o tiene una longitud de cero
        */
        for (editText in arrayEditText) {
            val texto = editText.text.toString() // Obtener el texto del EditText
            if (texto.isNullOrEmpty()) { // Verificar si el texto es nulo o vacío
                // Mostrar un mensaje de error
                Toast.makeText(this, R.string.alert_emptyfields, Toast.LENGTH_SHORT).show()

                // Cambiar el valor de la variable booleana a false
                allFieldsFilled = false

                // Salir del bucle
                break
            }
            // Si todos los campos están llenos, mostrar el mensaje de éxito
            // y redirige a la actividad welcome
            if (allFieldsFilled) {
                val positiveButton = { _: DialogInterface, _: Int ->
                    // Crear el intent para ir a la actividad principal
                    val mainActivityIntent = Intent(this, MainActivity::class.java)
                    // Iniciar la actividad
                    startActivity(mainActivityIntent)
                }
                val dialog = AlertDialog.Builder(this)
                    .setTitle(R.string.alert_registration_completed_tittle)
                    .setMessage(R.string.alert_registration_completed_message)
                    .setPositiveButton("OK", positiveButton)
                    .create().show()
            }
        }
    }
}