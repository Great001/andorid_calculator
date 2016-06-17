package com.lhc.calculate;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private TextView hello;
	private EditText input;
	private Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num0;
	private Button cheng,chu,jia,jian,clean,point,cal;
	private Button sin,cos,tan,back;
	
	private double f,r,factorOne=0,factorTwo=0,result=0;  //算数1，算数2，和计算结果
	private int tempInt=0,tpi;   //存储整数部分
	private int tempfl=0,tpf;    //存储小数部分
	private double n=1,tn;
    private double temp=0,tm;    //暂存算数
	private String symbol="",sb;   //存放运算符
	boolean jdg=false,jg;  //判断算数是否是小数的布尔变量
	String pointStr=".",pStr;   //存放小数点
	String str="";    //显示在编辑框的字符串
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setupContentView();  //导入各组件并设置监听器
	}

	
	private void setupContentView() {
		hello=(TextView)findViewById(R.id.hello);
		input=(EditText)findViewById(R.id.input);
		num1=(Button)findViewById(R.id.num1);
		num2=(Button)findViewById(R.id.num2);
		num3=(Button)findViewById(R.id.num3);
		num4=(Button)findViewById(R.id.num4);
		num5=(Button)findViewById(R.id.num5);
		num6=(Button)findViewById(R.id.num6);
		num7=(Button)findViewById(R.id.num7);
		num8=(Button)findViewById(R.id.num8);
		num9=(Button)findViewById(R.id.num9);
		num0=(Button)findViewById(R.id.num0);
		cheng=(Button)findViewById(R.id.cheng);
		chu=(Button)findViewById(R.id.chu);
		jia=(Button)findViewById(R.id.jia);
		jian=(Button)findViewById(R.id.jian);
		clean=(Button)findViewById(R.id.clean);
		point=(Button)findViewById(R.id.point);
		cal=(Button)findViewById(R.id.cal);
		sin=(Button)findViewById(R.id.sin);
		cos=(Button)findViewById(R.id.cos);
		tan=(Button)findViewById(R.id.tan);
		back=(Button)findViewById(R.id.back);
		
		
		num1.setOnClickListener(new clickOneListener());
		num2.setOnClickListener(new clickTwoListener());
		num3.setOnClickListener(new clickThreeListener());	
		num4.setOnClickListener(new clickFourListener());	
		num5.setOnClickListener(new clickFiveListener());
		num6.setOnClickListener(new clickSixListener());
		num7.setOnClickListener(new clickSevenListener());
		num8.setOnClickListener(new clickEightListener());
		num9.setOnClickListener(new clickNineListener());
		num0.setOnClickListener(new clickZeroListener());
		
		cheng.setOnClickListener(new clickChengListener());
		chu.setOnClickListener(new clickChuListener());
		jia.setOnClickListener(new clickJiaListener());
		jian.setOnClickListener(new clickJianListener());
		
		point.setOnClickListener(new clickPointListener());
		clean.setOnClickListener(new clickCleanListener());
		cal.setOnClickListener(new clickCalListener());
		
		back.setOnClickListener(new clickBackListener());	
		sin.setOnClickListener(new clickSinListener());
		cos.setOnClickListener(new clickCosListener());
		tan.setOnClickListener(new clickTanListener());
		
	}

     //计算算数1factorOne的方法
	private void CalFactorOne() {
		//当还没有任何运算符时，即还没有任何运算符输入时
		if(symbol.equals("")&&symbol.length()<=0) {
			factorOne=temp;
			result=factorOne;
		}
		//之前运算的结果和当下的算数进行运算，结果作为算数1
		else if(symbol=="*"||symbol=="/"||symbol=="+"||symbol=="-"){  //当已经有运算符输入时
		if(symbol.equals("*"))
		factorOne=result*temp;
		if(symbol.equals("/")) {
			if(temp!=0)
			factorOne=result/temp;
			else {
			    //toast对话框提示
				Toast to=Toast.makeText(getApplicationContext(), "������Ϊ�㣡",Toast.LENGTH_LONG);
				to.show();
			}
		}
		if(symbol.equals("+"))
			factorOne=result+temp;
		
		if(symbol.equals("-"))
			factorOne=result-temp;

		result=factorOne;  //将最终得到的算数1作为当下的结果
		}
		else if(symbol.equals("=")){
			factorOne=temp;
			result=factorOne;
		}
		else         //单元运算求算数1
			factorOne=result;
	
	}

	//按钮1的监听器
	class clickOneListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//当是小数时，输入小数部分
			if(jdg)
			{
				tempfl=10*tempfl+1;
				n=n/10;
				temp=tempInt+tempfl*n;
				input.setText(str+tempInt+pointStr+tempfl);  //将输入显示在编辑框中
			}
			else
			{
			tempInt=10*tempInt+1;
			temp=tempInt;
			input.setText(str+tempInt);
			}
		}
	}

	//按钮2的监听器
	class clickTwoListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(jdg) {
				tempfl=10*tempfl+2;
				n=n/10;
				temp=tempInt+tempfl*n;
				input.setText(str+tempInt+pointStr+tempfl);
			}
			else {
			tempInt=10*tempInt+2;
			temp=tempInt;
			input.setText(str+tempInt);
			}
		}
	}

	//按钮3的监听器
	class clickThreeListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(jdg) {
				tempfl=10*tempfl+3;
				n=n/10;
				temp=tempInt+tempfl*n;
				input.setText(str+tempInt+pointStr+tempfl);
			}
			else {
				tempInt = 10 * tempInt + 3;
				temp = tempInt;
				input.setText(str + tempInt);
			}
		}
		
	}

	//按钮4的监听器
	class clickFourListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(jdg) {
				tempfl=10*tempfl+4;
				n=n/10;
				temp=tempInt+tempfl*n;
				input.setText(str+tempInt+pointStr+tempfl);
			}
			else {
			tempInt=10*tempInt+4;
			temp=tempInt;
			input.setText(str+tempInt);
			}
			
		}
		
	}

	//按钮5的监听器
	class clickFiveListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(jdg) {
				tempfl=10*tempfl+5;
				n=n/10;
				temp=tempInt+tempfl*n;
				input.setText(str+tempInt+pointStr+tempfl);
			}
			else {
			tempInt=10*tempInt+5;
			temp=tempInt;
			input.setText(str+tempInt);
			}
		}
		
	}

	//按钮6的监听器
	class clickSixListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(jdg) {
				tempfl=10*tempfl+6;
				n=n/10;
				temp=tempInt+tempfl*n;
				input.setText(str+tempInt+pointStr+tempfl);
			}
			else {
			tempInt=10*tempInt+6;
			temp=tempInt;
			input.setText(str+tempInt);
			}
			
		}
		
	}

	//按钮7的监听器
	class clickSevenListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(jdg) {
				tempfl=10*tempfl+7;
				n=n/10;
				temp=tempInt+tempfl*n;
				input.setText(str+tempInt+pointStr+tempfl);
			}
			else {
			tempInt=10*tempInt+7;
			temp=tempInt;
			input.setText(str+tempInt);
			}
		}
		
	}

	//按钮8的监听器
	class clickEightListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(jdg) {
				tempfl=10*tempfl+8;
				n=n/10;
				temp=tempInt+tempfl*n;
				input.setText(str+tempInt+pointStr+tempfl);
			}
			else {
			tempInt=10*tempInt+8;
			temp=tempInt;
			input.setText(str+tempInt);
			}
			
		}
		
	}
	

	//按钮9的监听器
	class clickNineListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(jdg) {
				tempfl=10*tempfl+9;
				n=n/10;
				temp=tempInt+tempfl*n;
				input.setText(str+tempInt+pointStr+tempfl);
			}
			else {
			tempInt=10*tempInt+9;
			temp=tempInt;
			input.setText(str+tempInt);
			}
		}
		
	}

	//按钮0的监听器
	class clickZeroListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//是小数时的情况
			if(jdg) {
				tempfl=10*tempfl+0;
				n=n/10;
				temp=tempInt+tempfl*n;

				//考虑到小数点后第一位开始就是0的显示问题
				if(tempfl==0) {
					pointStr=pointStr+"0";
					input.setText(str+tempInt+pointStr);
				}
				else
				input.setText(str+tempInt+pointStr+tempfl);
			}
			else {
			tempInt=10*tempInt+0;
			temp=tempInt;
			input.setText(str+tempInt);
			}
		}
		
	}

	//按钮小数点的监听器
	class clickPointListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			jdg=true;
			input.setText(str+tempInt+".");
			
		}
	}

	//按钮乘的监听器
	class clickChengListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//利用变量存放各关键变量的值，以便退格恢复
			f=factorOne;
			r=result;
			sb=symbol;
			jg=jdg;
			pStr=pointStr;
			tpi=tempInt;
			tpf=tempfl;
			tn=n;
			tm=temp;

			CalFactorOne();  //按钮运算符时，先调用CalFactorOne方法计算出算数1

			symbol="*";
			//按钮运算符按钮后一些关键变量恢复初值
			jdg=false;
		    pointStr=".";
			tempInt=0;
			tempfl=0;
			n=1;
			temp=0;


			//判断是否是整数，以便调整输出
			int in=(int)result;
			if(result-in!=0) {
				str=result+symbol;
				input.setText(str);
			}
			else {
				str=in+symbol;
				input.setText(str);
			}
		}
		
	}


	//按钮除的监听器
	class clickChuListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			f=factorOne;
			r=result;
			CalFactorOne();
			sb=symbol;
			symbol="/";
			jg=jdg;
			jdg=false;
			pStr=pointStr;
		    pointStr=".";
		    tpi=tempInt;
			tempInt=0;
			tpf=tempfl;
			tempfl=0;
			tn=n;
			n=1;
			tm=temp;
			temp=0;
				
			int in=(int)result;
			if(result-in!=0) {
				str=result+symbol;
				input.setText(str);
			}
			else {
				str=in+symbol;
				input.setText(str);
			}
		}
		
	}


	//按钮加的监听器
	class clickJiaListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			f = factorOne;
			r = result;
			CalFactorOne();
			sb = symbol;
			symbol = "+";
			jg = jdg;
			jdg = false;
			pStr = pointStr;
			pointStr = ".";
			tpi = tempInt;
			tempInt = 0;
			tpf = tempfl;
			tempfl = 0;
			tn = n;
			n = 1;
			tm = temp;
			temp = 0;

			int in = (int) result;
			if (result - in != 0) {
				str = result + symbol;
				input.setText(str);
			} else {
				str = in + symbol;
				input.setText(str);
			}
		}
		
	}

	//按钮减的监听器
	class clickJianListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			f=factorOne;
			r=result;
			CalFactorOne();
			sb=symbol;
			symbol="-";
			jg=jdg;
			jdg=false;
			pStr=pointStr;
		    pointStr=".";
		    tpi=tempInt;
			tempInt=0;
			tpf=tempfl;
			tempfl=0;
			tn=n;
			n=1;
			tm=temp;
			temp=0;
				
			int in=(int)result;
			if(result-in!=0) {
				str=result+symbol;
				input.setText(str);
			}
			else {
				str=in+symbol;
				input.setText(str);
			}
	 }
		
	}

	//按钮sin的监听器
	class clickSinListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			f=factorOne;
			r=result;
			CalFactorOne();
			sb=symbol;
			symbol="sin";
			jg=jdg;
			jdg=false;
			pStr=pointStr;
		    pointStr=".";
		    tpi=tempInt;
			tempInt=0;
			tpf=tempfl;
			tempfl=0;
			tn=n;
			n=1;
			tm=temp;
			temp=0;
				
			int in=(int)result;
			if(result-in!=0) {
				str=result+symbol;
				input.setText(str);
			}
			else {
				str=in+symbol;
				input.setText(str);
			}
	 }
	}

	//按钮cos的监听器
	class clickCosListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			f=factorOne;
			r=result;
			CalFactorOne();
			sb=symbol;
			symbol="cos";
			jg=jdg;
			jdg=false;
			pStr=pointStr;
		    pointStr=".";
		    tpi=tempInt;
			tempInt=0;
			tpf=tempfl;
			tempfl=0;
			tn=n;
			n=1;
			tm=temp;
			temp=0;
				
			int in=(int)result;
			if(result-in!=0) {
				str=result+symbol;
				input.setText(str);
			}
			else {
				str=in+symbol;
				input.setText(str);
			}
		}
		
	}

	//按钮tan的监听器
	class clickTanListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			f=factorOne;
			r=result;
			CalFactorOne();
			sb=symbol;
			symbol="tan";
			jg=jdg;
			jdg=false;
			pStr=pointStr;
		    pointStr=".";
		    tpi=tempInt;
			tempInt=0;
			tpf=tempfl;
			tempfl=0;
			tn=n;
			n=1;
			tm=temp;
			temp=0;
				
			int in=(int)result;
			if(result-in!=0) {
				str=result+symbol;
				input.setText(str);
			}
			else {
				str=in+symbol;
				input.setText(str);
			}
			
		}
		
	}


	//按钮退格的监听器
	class clickBackListener implements OnClickListener
	{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String text=input.getText().toString();  //从编辑框中取得text,通过退格的字符进行判断
			int len=text.length()-1;  //变脸存放text中退格字符的所在数组下标
			char ch=text.charAt(len);  //通过下标从字符处中获取该字符

			//对该字符进行分析判断，还原上一步操作
			if(ch>='0'&&ch<='9') {   //是数字
				if(jdg) {   //小数
					if(tempfl==0)
						pointStr=pointStr.substring(0,pointStr.length()-1);  //pointStr中减去一个0
					tempfl=tempfl/10;
					n=n*10;
					temp=tempInt+tempfl*n;
				}
				else {
					tempInt=tempInt/10;
					temp=tempInt;
					if(symbol=="="){
						result=temp;
						str="";
					}
				}

				text=text.substring(0,len);
				input.setText(text);
			}
			else if(ch=='.') {  //是小数点
				jdg=false;
				text=text.substring(0,len);
				input.setText(text);
			}
			else if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				//还原关键变量
				factorOne=f;
				result=r;
				symbol=sb;
				if(symbol=="")
					str="";
				tempInt=tpi;
				tempfl=tpf;
				temp=tm;
				jdg=jg;
				pointStr=pStr;
				n=tn;
				str=str.substring(0,len);
				text=text.substring(0,len);
				input.setText(text);
			}
			else {  //正余弦运算符
				symbol=sb;
				tempInt=tpi;
				tempfl=tpf;
				temp=tm;
				jdg=jg;
				pointStr=pStr;
				n=tn;
				str=str.substring(0,len);
				text=text.substring(0,len-2);
				input.setText(text);
			}
		}
		
	
	}

	//按钮等号的监听器
	class clickCalListener implements OnClickListener
	{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			jdg=false;
			pointStr=".";
			n=1;
			factorTwo=temp;
			if(symbol.equals("*")) {
				result=factorOne*factorTwo;
				
			}
			if(symbol.equals("/")) {
				if(factorTwo!=0)
				result=factorOne/factorTwo;
				else {      //提示除数不能为零
					result=0;
					Toast toast=Toast.makeText(getApplicationContext(), "������Ϊ�㣡����", Toast.LENGTH_LONG);
					toast.show();
				}
			}
			if(symbol.equals("+")) {
				result=factorOne+factorTwo;
			}
			if(symbol.equals("-")) {
				result=factorOne-factorTwo;
			}
			if(symbol.equals("")) {
				Toast ts=Toast.makeText(getApplicationContext(), "��������",Toast.LENGTH_LONG);
				ts.show();
				
			}
			
			if(symbol.equals("sin")) {
				result=Math.sin(factorOne);
			}
			
			if(symbol.equals("cos")) {
				result=Math.cos(factorOne);
			}
			
			if(symbol.equals("tan")) {
				result=Math.tan(factorOne);
			}
			symbol="=";
			int in=(int)result;
			
			if(result-in!=0){
				str=""+result;
				input.setText(""+result);
				str=result+"";
				tempInt=in;
			}
			else {
				str=""+in;
				input.setText(""+in);
				str=in+"";
				tempInt=in;
			}
		}
		
	}
	
	
	//按钮清零的监听器
	class clickCleanListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			jdg=false;
			pointStr=".";
			symbol="";
			tempInt=0;
			tempfl=0;
			n=1;
			temp=0;
			factorOne=0;
			factorTwo=0;
			result=0;
			str="";
			input.setText(str);
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
	
	


