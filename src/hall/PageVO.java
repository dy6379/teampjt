package hall;

public class PageVO {

	private int startPage;//첫페이지
	private int endPage;//마지막페이지
	private boolean prev, next;//이전,다음
	
	private int pageNum;//현재페이지
	private int amount=10;//화면에 그려질 데이터
	private int total;//전체 게시글수
	
	public PageVO(int pageNum, int amount, int total) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.total = total;
		
		//끝페이지 - 페이지네이션개수 +1
		this.startPage = this.endPage-10 +1;
		//(페이지번호/페이지네이션개수) * 페이지네이션개수 = endPage는 10단위
		this.endPage = (int)Math.ceil(this.pageNum * 0.1)*10;
		//진짜 끝번호 : 전체게시글수/10개씩페이지네이션
		int realEnd = (int)Math.ceil(this.total/(double)this.amount);
		//endPage설정 endPage = 10, realEnd = 14 => 보여질 끝번호 10
					// endPage = 20, realEnd = 14 => 보여질 끝번호 14
		if(this.endPage>realEnd) {
			this.endPage=realEnd;
		}
		//이전
		this.setPrev(this.startPage>1);
		//다음 endPage설정 endPage = 10, realEnd = 14 => 다음O
						//endPage = 20, realEnd = 14 => 다음X
		this.setNext(this.endPage<realEnd);
		
		
	}

	public boolean getPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean getNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
	
}
