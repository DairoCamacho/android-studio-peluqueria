package co.edu.sena.peluqueriaalejandra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
// se requiere la siguiente importe para crear las variables privadas edtUsername y edtPassword
import android.widget.EditText
// se requiere la siguiente importe para la función del boton login
import android.content.Intent
// se requiere la siguiente importe para la función del boton login
import android.view.View
// se requiere la siguiente importe para construir la ventana del Dialogo
import androidx.appcompat.app.AlertDialog
// se requiere la siguiente importe para mostrar los botones de la ventana del Dialogo
import android.content.DialogInterface

// para que una actividad puede hacer una  actividad debe heredar de una de las  diferentes clases activity que existen, en este caso esta actividad hereda de AppCompatActivity
class MainActivity : AppCompatActivity() {
    // creamos las referencias de los objetos con los que vamos a interactuar
    // var indica que es una variable que puede cambiar su contenido ( a diferencia de val que no puede modificarse)
    // la sintaxis de la variable es nombre, dos puntos, tipo de variable, igual, valor inicial.
    // el signo de interrogacion indica que puede contener un valor null
    private var edtUsername: EditText? = null
    private var edtPassword: EditText? = null

    // un método (sobrescrito) que no puede faltar en ninguna actividad es onCreate, la cual es donde se carga y donde se crea la actividad para poder ser mostrada
    override fun onCreate(savedInstanceState: Bundle?) {
        // la primera línea de esta función siempre es un llamado al método onCreate de la clase padre, por eso la palabra super
        super.onCreate(savedInstanceState)

        //este método setContentView se encarga de cargar el diseño o el xml que nosotros hayamos destinado para esa actividad,
        // entonces debemos asegurarnos de que a quien estemos llamando el layout que corresponde en este caso a activity_main
        setContentView(R.layout.activity_main)

        // aquí inicializamos las variables credas en las lineas 18 y 19
        //Nota: Siempre se inicializan despues del metodo setContentView ya él se encarga de cargar el diseño y no podemos referenciar un objeto si el diseño no ha sido cargado previamente
        edtUsername= findViewById(R.id.et_username)
        edtPassword= findViewById(R.id.et_reg_password)

        // el siguiente metodo es para llamar al Toolbar pero no lo usaremos en esta app
        // setSupportActionBar(findViewById(R.id.my_toolbar))
    }

    // Función para el botón Login
    // el parametro de objeto view representa el objeto que se pulsa, osea el boton.
    fun onLogin(view: View){
        // convertimos los valores a String y los almacenamos
        // Usar el operador !!. (non-null assertion) sirven para validar que el objeto no este nulo antes de extraer los datos
        // Usar el operador !!. (non-null assertion), que fuerza la llamada al método toString() aunque el EditText sea nulo. Si el EditText es nulo, lanza una excepción de tipo NullPointerException.
        var username: String = edtUsername!!.text.toString()
        var password: String = edtPassword!!.text.toString()

        // este es un ejemplo de practica para comprar los valores ingresados en el login con datos quemados (hardcoded)
        // el usuario será: 123 y la clave será:   456
        if(username== "123" && password=="456"){
                val intento = Intent(this, WelcomeActivity::class.java)
                startActivity(intento)
        } else {
            val positiveButton = {_: DialogInterface, _: Int -> }
            val dialog = AlertDialog.Builder(this)
                .setTitle("ERROR!")
                .setMessage(R.string.alert_errorlogin)
                .setPositiveButton("X", positiveButton)
                .create().show()
        }
    }

    // Función para el botón Create Account
    fun onCreate(view: View) {
        val intento = Intent(this, RegistrationActivity::class.java)
        startActivity(intento)
    }
}