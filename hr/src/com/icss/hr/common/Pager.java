package com.icss.hr.common;

import org.eclipse.jdt.internal.compiler.batch.Main;

/**
 * ��ҳ������
 * @author Administrator
 *
 */
public class Pager {
	
	private int recordCount;//�ܼ�¼��
	
	private int pageSize = 10;//ÿҳ������
	
	private int pageCount;//����ҳ
	
	private int pageNum;//��ǰҳ��
	
	private int start;//��¼��ʼλ��
	
	private int end;//��¼��ֹλ��
	
	public Pager(int recordCount,int pageSize,int pageNum) {
		
		//���Ը�ֵ
		this.recordCount = recordCount;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		
		//���㹲��ҳ
		this.pageCount = this.recordCount / this.pageSize;
		if (this.recordCount % this.pageSize != 0)
			this.pageCount ++;
		
		//���㵱ǰҳ��
		if (this.pageNum < 1)
			this.pageNum = 1;
		if (this.pageNum > this.pageCount)
			this.pageNum = this.pageCount;
		
		//������ʼ����ֹλ��
		this.start = (this.pageNum - 1) * this.pageSize + 1;
		this.end = this.pageNum * this.pageSize;		
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

}