package edu.quinnipiac.ser210.firstapp2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener

//For Spinner, we have to extend the spinner thing
class MainActivity : AppCompatActivity(), OnItemSelectedListener{

    var input1: EditText? = null
    var input2: EditText? = null
    var res: TextView? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input1 = findViewById<EditText>(R.id.input)
        input2 = findViewById<EditText>(R.id.input2)
        res = findViewById<EditText>(R.id.result_label)

        findViewById<Button>(R.id.addition).setOnClickListener{
           performOp('+')
        }

        findViewById<Spinner>(R.id.spinner).onItemSelectedListener = this
    }

    private fun performOp(op:Char) {
        //read from input1 and input2

        if (input1 != null && input2 != null) {
        val num1: Double = input1?.getText().toString().toDouble()
        val num2: Double = input2?.getText().toString().toDouble()
        Log.v("Debug", "num 1" + num1 + "num 2" + num2)

        var result = 0.0
        when (op) {
            '+' -> result = num1 + num2
            '-' -> result = num1 - num2
            '*' -> result = num1 * num2
            '/' -> result = num1 / num2
        }
        //update the value of text in the result textview
        res?.setText(java.lang.Double.toString(result));
    }
}
    fun subtraction(view: View?){
        this.performOp('-')
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val op = p0?.getItemAtPosition(p2).toString();
        if(!op.equals("none"))
            this.performOp(op[0])
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}