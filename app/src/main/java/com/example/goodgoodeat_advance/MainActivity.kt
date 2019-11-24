package com.example.goodgoodeat_advance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var selectTime: Spinner
    lateinit var order: TextView
    lateinit var submit_button:Button
    var order_meal:String? = ""
    var order_time:String? = ""
    var order_add:String? = ""

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        selectTime = findViewById(R.id.selectTime)
        submit_button = findViewById(R.id.submitButton1)

        var adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,
            R.array.deliveryTime,
            R.layout.support_simple_spinner_dropdown_item)
        selectTime.adapter = adapter
        selectTime.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var item:Any = parent!!.getItemAtPosition(position)
                Toast.makeText(this@MainActivity,"您選擇的外送時段是：$item", Toast.LENGTH_LONG).show()
                order_time = "外送時間：\n$item\n"
            }
        }

        var add_RadioGroup: RadioGroup = findViewById(R.id.add_RadioGroup)

        add_RadioGroup.setOnCheckedChangeListener { group, checkedId ->
            var radio:RadioButton = findViewById(checkedId)
            Toast.makeText(this,"您決定要：${radio.text}",Toast.LENGTH_LONG).show()
            order_add = radio.text.toString() +"\n"
        }

        var NO1: CheckBox = findViewById(R.id.NO1)
        var NO2: CheckBox = findViewById(R.id.NO2)
        var NO3: CheckBox = findViewById(R.id.NO3)
        var NO4: CheckBox = findViewById(R.id.NO4)
        var NO5: CheckBox = findViewById(R.id.NO5)
        var NO6: CheckBox = findViewById(R.id.NO6)

        NO1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                Toast.makeText(this@MainActivity, "已選取：${NO1.text}", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this@MainActivity, "已取消：${NO1.text}", Toast.LENGTH_LONG).show()
            }
        }
        NO2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Toast.makeText(this@MainActivity,"已選取：${NO2.text}",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this@MainActivity,"已取消：${NO2.text}",Toast.LENGTH_LONG).show()
            }
        }
        NO3.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                Toast.makeText(this@MainActivity, "已選取：${NO3.text}", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this@MainActivity, "已取消：${NO3.text}", Toast.LENGTH_LONG).show()
            }
        }
        NO4.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                Toast.makeText(this@MainActivity, "已選取：${NO4.text}", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this@MainActivity, "已取消：${NO4.text}", Toast.LENGTH_LONG).show()
            }
        }
        NO5.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                Toast.makeText(this@MainActivity, "已選取：${NO5.text}", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this@MainActivity, "已取消：${NO5.text}", Toast.LENGTH_LONG).show()
            }
        }
        NO6.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                Toast.makeText(this@MainActivity, "已選取：${NO6.text}", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this@MainActivity, "已取消：${NO6.text}", Toast.LENGTH_LONG).show()
            }
        }

        submitButton1.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            val bag = Bundle()

            order_meal = ""
            if (NO1.isChecked)
                order_meal += NO1.text.toString() + "\n"
            if (NO2.isChecked)
                order_meal  += NO2.text.toString() +"\n"
            if (NO3.isChecked)
                order_meal  += NO3.text.toString() +"\n"
            if (NO4.isChecked)
                order_meal  += NO4.text.toString() +"\n"
            if (NO5.isChecked)
                order_meal  += NO5.text.toString() +"\n"
            if (NO6.isChecked)
                order_meal  += NO6.text.toString() +"\n"

            bag.putString("Time", "$order_time")
            bag.putString("Meal", "您選擇的餐點為：\n$order_meal")
            bag.putString("Add", "是否加價購：\n$order_add")
            intent.putExtras(bag) //要加這句才能run
            intent.setClass(this@MainActivity, CheckOrderActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
}

