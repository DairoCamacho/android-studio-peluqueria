package co.edu.sena.peluqueriaalejandra

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AppointmentActivity : AppCompatActivity() {
    private var sp_services: Spinner? = null
    private var sp_employee: Spinner? = null
    private var et_date: EditText? = null
    private var et_time: EditText? = null
    private var tv_value: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        // Obtener los EditText por sus IDs y asignarlos a las variables de clase
        sp_services = findViewById(R.id.sp_services)
        sp_employee = findViewById(R.id.sp_employee)
        et_date = findViewById(R.id.et_date)
        et_time = findViewById(R.id.et_time)
        tv_value = findViewById(R.id.tv_value)

        /*
        val adapter = ArrayAdapter<CharSequence>(this, R.array.services, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item)
        */
        val serviceList = arrayOf("","manicure","pedicure","colorimetría","secado","planchado","cepillado","corte de pelo","barbería")
        // usando el adapter enviar el contenido del array "serviceList"a la vista para ser mostrados dentro del spinner
        // val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, serviceList)
        val adapterServices = ArrayAdapter<String>(this, R.layout.spinner_item, serviceList)
        sp_services?.let { it.adapter = adapterServices }

        val employeeList = arrayOf("","Alejandra","Mary","Andrea")
        val adapterEmployee = ArrayAdapter<String>(this, R.layout.spinner_item, employeeList)
        sp_employee?.let { it.adapter = adapterEmployee }
    }

    // Mostrar un mensaje de error
    fun showErrorEmpyField() {
        Toast.makeText(this, R.string.alert_emptyfields, Toast.LENGTH_SHORT).show()
    }

    fun OnCreateAppointment(view: View) {
        println(sp_employee?.selectedItem.toString())
        println(sp_services?.selectedItem.toString())

        when (sp_employee?.selectedItem.toString()) {
            "" -> {showErrorEmpyField(); return}
        }

        // funciona como un switch, dependiendo del valor seleccionado del spinner hace una acción.
        when (sp_services?.selectedItem.toString()) {
            "" -> {showErrorEmpyField(); return}
            "manicure" -> tv_value?.text = "$ 15.000"
            "pedicure" -> tv_value?.text = "$ 20.000"
            "colorimetría" -> tv_value?.text = "$ 100.000"
            "secado" -> tv_value?.text = "$ 20.000"
            "planchado" -> tv_value?.text = "$ 15.000"
            "cepillado" -> tv_value?.text = "$ 15.000"
            "corte de pelo" -> tv_value?.text = "$ 12.000"
            "barbería" -> tv_value?.text = "$ 10.000"
        }

        // verificar si todos los campos están llenos
        if (sp_services?.selectedItem.toString().isBlank() && sp_employee?.selectedItem.toString().isBlank()
            && et_date?.text.toString().isBlank() && et_time?.text.toString().isBlank() ) {
            showErrorEmpyField()
            return
        }

        // Mostrar mensaje de éxito
        val positiveButton = { _: DialogInterface, _: Int -> }
        val dialog = AlertDialog.Builder(this).apply {
            setTitle(R.string.alert_appointment_created_title)
            setMessage(R.string.alert_appointment_created_message)
            setPositiveButton("X", positiveButton)
        }.create().show()
    }

    fun onClean(view: View) {
        // Limpiar los campos de los EditText y cambiar el valor del TextView
        et_date?.setText("")
        et_time?.setText("")
        tv_value?.text = ""
        sp_services?.setSelection(0)
        sp_employee?.setSelection(0)
    }

/*
    fun onBack(view: View) {
        val intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
    }
*/
}
