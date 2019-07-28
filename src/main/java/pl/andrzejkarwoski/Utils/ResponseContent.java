package pl.andrzejkarwoski.Utils;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class ResponseContent {
	private byte[] content;

	public ResponseContent(List<String> list) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			for (String line : list) {
				baos.write(line.getBytes());
				baos.write('\n');
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		this.content = baos.toByteArray();
	}

	public byte[] getContent() {
		return content;
	}

}
