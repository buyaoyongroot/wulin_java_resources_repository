package package1.package02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;


public class Test2 extends JFrame implements MouseListener,ActionListener{
	JTree tree;
	JPopupMenu popMenu;
	JMenuItem addItem;
	JMenuItem delItem;
	JMenuItem editItem;
	public Test2() {
		
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("���ڵ�");
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("�ڵ�1");
		DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("�ڵ�2");
		DefaultMutableTreeNode node11 = new DefaultMutableTreeNode("�ڵ�11");
		
		root.add(node1);
		root.add(node2);
		node1.add(node11);
		
		
		tree = new JTree(root);
		tree.setEditable(true);
		tree.addMouseListener(this);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		
		
		popMenu = new JPopupMenu();
		addItem = new JMenuItem("����ӽڵ�");
		addItem.addActionListener(this);
		delItem = new JMenuItem("ɾ��");
		editItem = new JMenuItem("�޸�");
		
		popMenu.add(addItem);
		popMenu.add(delItem);
		popMenu.add(editItem);
		
		tree.getCellEditor().addCellEditorListener(new CellEditorListener() {
			
			@Override
			public void editingStopped(ChangeEvent arg0) {
				System.out.println("jjjjj");
				System.out.println("�༭����");
			}
			
			@Override
			public void editingCanceled(ChangeEvent arg0) {
				System.out.println("�༭ȡ��");
			}
		});   
		
		//tree.setCellRenderer(new MyRenderer());
		this.add(tree);
		
	}

	public static void main(String[] args) {
		Test2 frame = new Test2();
		frame.setBounds(900, 100, 300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent e) {
		TreePath path = tree.getPathForLocation(e.getX(), e.getY()); // �ؼ������������ʹ��
		if (path == null) {
			return;
		}
		String s=path.toString();
	   // System.out.println(s);
		System.out.println((DefaultMutableTreeNode)path.getPathComponent(0));
		
		int j=s.lastIndexOf(",");
		int len=s.length();
		String str=null;
		if(j!=-1){
			str=s.substring(j+1,len-1);
			//System.out.println(str);
		}else{
			//System.out.println(s);
		}
		
		
		//tree.setSelectionPath(path);
		//String path2=tree.getLastSelectedPathComponent().toString();
		//System.out.println("haha---"+path2);
		
		int i=e.getClickCount();
		//System.out.println(i);
		
		//System.out.println(e.getButton());
		
		if (e.getButton() == 3) {
			popMenu.show(tree, e.getX(), e.getY());
			//System.out.println("jd");
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}
	public void actionPerformed(ActionEvent e) {
		DefaultMutableTreeNode parent = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
		System.out.println("===="+parent);
		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("�½ڵ�");
		parent.add(newNode);
		
		//ˢ���½��ڵ���ɺ����
		DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
		TreeNode[] nodes = model.getPathToRoot(newNode);  
		System.out.println(nodes);
        TreePath path = new TreePath(nodes);  
        tree.scrollPathToVisible(path);  
        tree.updateUI();
        
        TreePath newNodePath = new TreePath(newNode.getPath());
		tree.getSelectionModel().addSelectionPath(newNodePath);
		
		tree.getCellEditor().addCellEditorListener(new CellEditorListener() {
			
			@Override
			public void editingStopped(ChangeEvent arg0) {
				System.out.println("�༭����");
			}
			
			@Override
			public void editingCanceled(ChangeEvent arg0) {
				System.out.println("�༭ȡ��");
			}
		});   
	}
}
