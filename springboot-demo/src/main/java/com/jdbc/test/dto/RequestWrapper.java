package com.jdbc.test.dto;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;

import com.sun.el.stream.Stream;

import net.bytebuddy.agent.builder.ResettableClassFileTransformer;

public class RequestWrapper extends HttpRequestWrapper {

	private class ResetableServletInputStream extends ServletInputStream {

		private InputStream stream;

		@Override
		public boolean isFinished() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setReadListener(ReadListener listener) {
			// TODO Auto-generated method stub

		}

		@Override
		public int read() throws IOException {
			// TODO Auto-generated method stub
			return stream.read();
		}

	}

	private byte[] rewData;
	private ResetableServletInputStream resetableServletInputStream;

	public RequestWrapper(HttpRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

}
