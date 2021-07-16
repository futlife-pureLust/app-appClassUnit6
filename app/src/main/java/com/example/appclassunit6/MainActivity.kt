package com.example.appclassunit6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//手動import
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //宣告要顯示在列表上的字串
        val array = arrayOf("項目1","項目2","項目3","項目4","項目5")

        btn_toast.setOnClickListener{
            showToast("預設Toast")
        }
        btn_custom.setOnClickListener{
            //宣告Toast物件
            val toast=Toast(this)
            //設定Toast的顯示位制
            toast.setGravity(Gravity.TOP,0,50)
            //設定Toast的持續時間
            toast.duration=Toast.LENGTH_SHORT
            //設定自定義的Toast畫面
            toast.view=View.inflate(this,R.layout.custome_toast,null)
            //顯示Toast
            toast.show()
        }
        btn_dialog1.setOnClickListener {
            //宣告AlertDiaLog物件，setButton可以在Dialog對應位制顯示按鈕
            AlertDialog.Builder(this)
                .setTitle("按鍵式對話框")//顯示標題
                .setMessage("對話框內容")//顯示文字內容
                .setNeutralButton("取消"){dialog,which->
                    showToast("取消")
                 }
                .setNegativeButton("拒絕"){dialog,which->
                    showToast("拒絕")
                }
                .setNegativeButton("確定"){dialog,which->
                    showToast("確定")
                }.show()
        }
        btn_dialog2.setOnClickListener{
            //宣告AlertDialog物件，setItens可以在Dialog顯示列表
            AlertDialog.Builder(this)
                .setTitle("列表示對話框")//顯示標題
                .setItems(array){dislogInterface,i->
                    showToast("你選的是"+array[i])
                }.show()//顯示Dialog
        }
        btn_dialog3.setOnClickListener {
            //宣告變數用以保存選擇位制
            var position=0
            //宣告AlertDialog物件，setSignLeChoiceItems可以在Dialog顯示單選框
            AlertDialog.Builder(this)
                .setTitle("單選式對話框")//顯示標題
                .setSingleChoiceItems(array,0){dialogInterface,
                i->
                    position = i
                }
                .setPositiveButton("確定"){dialog,which->
                    showToast("你選的是"+array[position])
                }.show()//顯示Dialog
        }
    }
    //使用預設Toast顯示文字訊息
    private fun showToast(text: String)=
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
}