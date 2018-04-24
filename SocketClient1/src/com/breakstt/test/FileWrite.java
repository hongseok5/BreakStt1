package com.breakstt.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.breakstt.util.DataBody;
import com.breakstt.util.DataHeader;
import com.breakstt.util.DataMerging;

public class FileWrite {

	public static void main(String[] args) {
		
		String id = "hongseok5";
		String pw = "1234abcd";
		String etc = "11한글파라미터22";
		String etc2 = "33테스트44";
		List<String> params = new ArrayList<String>();
		params.add(id);
		params.add(pw);
		params.add(etc);
		params.add(etc2);

		DataHeader dh = new DataHeader(params, (byte) 76);
		
		try {
			File file = new File("/home/hongseok/fosex5.txt");
			FileOutputStream fos = new FileOutputStream(file);

			DataBody dataBody = new DataBody((byte)76, params);
			DataMerging data1 = new DataMerging(dh, dataBody);
			
			// 클라이언트 클래스에서 생성 후 fillWithNVL을 사용하면 파라미터를 쓰게 된다.
			// 이 과정을 생성자 안에 넣어서 생략한다. 
			// 생성자로 문자열 배열이나 콜렉션을 넣어준다. 
			// 헤더와 바디를 합쳐주는 클래스를 구현하고 생성자로 헤더와 바디를 넣는다. 
			// 파라미터로 던질 스트링리스트를 바탕으로 데이터 헤더의 데이터 사이즈 부분을 넣어준다.
			
			/*
			String strData = "";
			StringBuilder sb = new StringBuilder(); 
			for(int i = 0; i < eData.length; i++ ) {
				//System.out.print(eData[i]);
				strData +=eData[i];
				sb.append(eData[i]);
				 
			}			 
			System.out.println(sb.toString());
			*/
			
			fos.write(data1.getMergedData());
			fos.flush();
			fos.close();
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
}
		
	}

}