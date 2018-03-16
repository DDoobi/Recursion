
// 201402415 , 장진우

public class RecursionLinkedList {

	public Node head;
	private static char UNDEF = Character.MIN_VALUE;

	/* ���Ӱ� ������ ��带 ����Ʈ�� ó������ ���� */
	private void linkFirst(char element) {
		head = new Node(element, head);
	}

	/* �־��� Node x�� ���������� ����� Node�� �������� ���Ӱ� ������ ��带 ���� */
	private void linkLast(char element, Node x) {
		if (x.next == null) { // ������ ����ΰ��
			x.next = new Node(element, null);
		} else { // ������ ��尡 �ƴѰ��
			linkLast(element, x.next); // ���� ��忡���Ͽ� linkLastȣ��
		}
	}

	/* ���� Node�� ���� Node�� ���Ӱ� ������ ��带 ���� */
	private void linkNext(char element, Node pred) {
		Node next = pred.next;
		pred.next = new Node(element, next);
	}

	/* ����Ʈ�� ù��° ���� ����(����) * * @return ù��° ������ ������ */
	private char unlinkFirst() {
		Node x = head;
		char element = x.item;
		head = head.next;
		x.item = UNDEF;
		//x.next = null;
		return element;
	}

	/*
	 * ����Node �� ���� Node���� ����(����) * * @param pred * ������� * @return
	 * ��������� ������
	 */
	private char unlinkNext(Node pred) {
		Node x = pred.next;
		Node next = x.next;
		char element = x.item;
		x.item = UNDEF;
		x.next = null;
		pred.next = next;
		return element;
	}

	/* ����Ʈ���� index ��ġ�� ���� ��ȯ */
	public char get(int index) {
		if (!(index >= 0 && index < size()))
			throw new IndexOutOfBoundsException("" + index);

		return node(index, head).item;
	}

	/* ���Ҹ� ����Ʈ�� �������� �߰� */
	public boolean add(char element) {
		if (head == null) {
			linkFirst(element);
		} else {
			linkLast(element, head);
		}

		return true;
	}

	/* ���Ҹ� �־��� index ��ġ�� �߰� */
	public void add(int index, char element) {
		if (!(index >= 0 && index <= size()))
			throw new IndexOutOfBoundsException("" + index);

		if (index == 0)
			linkFirst(element);
		else
			linkNext(element, node(index - 1, head));
	}

	/* ����Ʈ���� index ��ġ�� ���� ���� */
	public char remove(int index) {
		if (!(index >= 0 && index < size()))
			throw new IndexOutOfBoundsException("" + index);

		if (index == 0) {
			return unlinkFirst();
		}
		return unlinkNext(node(index - 1, head));
	}

	/* x��忡�� index��ŭ ������ Node ��ȯ */
	public Node node(int index, Node x) {
		if (index >= size()) { // x��忡�� ������ ������ ��� ���� �Ѿ ���
			System.out.println("�ʰ� �Ͽ����ϴ�.");
			return null;
		}
		if (index == 0) { // index��ŭ ������ ��带 ã���� ���
			return x;
		} else {
			return node(index - 1, x.next); // index�� �ٿ��� ���� ��忡���Ͽ�
											// nodeȣ��
		}

	}

	/* ����(5) ���� ����� ���� ������ ����Ʈ�� �������� �Ųٷ� ���� */
	private void reverse(Node x, Node pred) {
		// ä���� ���, recursion ���

		if (x != null) { 
			pred = new Node(remove(0), x.next); //pred에 새로운 노드 생성
			reverse(x.next, pred); //재귀이용
			add(pred.item); 
		}

	}

	/* ���κ��� �������� ����Ʈ�� ��� ���� ��ȯ */
	private int length(Node x) {

		if (x == null) { // ��尡 ���� ���
			return 0;
		} else // ��尡 �������
			return 1 + length(x.next); // ���� ��忡 ���Ͽ� lengthȣ��

	}

	/* ���κ��� �����ϴ� ����Ʈ�� ���� ��ȯ */
	private String toString(Node x) {

		if (x == null) { // ��尡 ���°��
			return "";
		} else {
			return x.item + toString(x.next); // x.item ��� + ���� ��忡 ���Ͽ�
												// toStringȣ��
		}
	}

	/* ����Ʈ�� ���� ���� ��ȯ */
	public int size() {
		return length(head);
	}

	/* ����Ʈ�� �Ųٷ� ���� */
	public void reverse() {
		reverse(head, null);
	}

	public String toString() {
		if (head == null)
			return "[]";

		return "[ " + toString(head) + " ]";
	}

	/* ����Ʈ�� ���� �ڷᱸ�� */
	public static class Node {
		char item;
		Node next;

		Node(char element, Node next) {
			this.item = element;
			this.next = next;
		}
	}
}
