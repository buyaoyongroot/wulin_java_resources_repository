package cn.scxh.ittx.ui.shared;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.domain.MedicineClassify;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.service.impl.MedicineClassifyServiceImpl;
import cn.scxh.ittx.service.intf.MedicineClassifyService;

public class MedicineClassifyTree {
	private DefaultMutableTreeNode myNode;
	private DifferenceObject object;

	public MedicineClassifyTree(DifferenceObject object) {
		this.object = object;
	}

	// ����һ������һ�����ڵ�
	public void createTreeAndNode() {
		JPanel jPanel10 = object.getJpanel();
		MedicineClassifyService mcf = new MedicineClassifyServiceImpl();
		List<MedicineClassify> classifyList = null;
		try {
			classifyList = mcf.getMedicineRoot(null);
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
		myNode = new DefaultMutableTreeNode(classifyList
				.get(0).getName());
		try {
			recursionCreateMedicineClassifyTree(mcf, classifyList.get(0), myNode);
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
		JTree jTree = new JTree(myNode);
		jTree.setEditable(true);
		ListenerTheTree(jTree);
		jTree.setBounds(0, 140, 300, 600);
		jPanel10.add(jTree);

	}

	// ��������
	public void ListenerTheTree(final JTree jTree) {
		jTree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				userDefinedCreateNode(jTree, e);
				if (e.getButton() != 3) {
					TreePath path = jTree
							.getPathForLocation(e.getX(), e.getY());
					MedicineClassify classify = getSelectedNodeInformation(path);
					System.out.println("classify" + classify.getName());
				}
			}
		});
	}

	// ȡ����ѡ��Ľڵ��������Ϣ
	public MedicineClassify getSelectedNodeInformation(TreePath path) {
		MedicineClassifyService mcf = new MedicineClassifyServiceImpl();
		MedicineClassify classify = new MedicineClassify();
		if (path != null) {
			int i = path.getPathCount();
			for (int j = 0; j < i; j++) {
				try {
					if (j == 0) {
						classify = mcf.getMedicineRoot(classify).get(0);
					} else {
						classify.setName(path.getPathComponent(j).toString());
						classify = mcf.getChildrenBynameAndId(classify).get(0);
					}
				} catch (QueryObjectException e1) {
					e1.printStackTrace();
				}

			}
			// System.out.println(classify.getId() + "="
			// + classify.getName());

		}
		return classify;
	}

	// �Զ��崴���ڵ�
	public void userDefinedCreateNode(JTree jTree, MouseEvent e) {
		TreePath path = jTree.getPathForLocation(e.getX(), e.getY());
		// int i = path.getPathCount();
		JPopupMenu menu = rightKeyMenu(jTree);
		boolean flag = jTree.isPathSelected(path); // �жϵ�ǰ�ڵ��Ƿ��б�ѡ��
		if (flag) {
			if (e.getButton() == 3) {
				System.out.println(flag);
				menu.show(jTree, e.getX(), e.getY());
				int i = menu.getComponentCount();

			}
		}

	}

	// �Ҽ��˵�
	public JPopupMenu rightKeyMenu(JTree jTree) {
		JPopupMenu menu = new JPopupMenu();
		JMenuItem equalItem = new JMenuItem("����ͬ��Ŀ¼");
		rightKeyMenuListener(jTree, equalItem);
		JMenuItem downItem = new JMenuItem("������һ��Ŀ¼");
		rightKeyMenuListener(jTree, downItem);
		JMenuItem editItem = new JMenuItem("�༭��ǰĿ¼");
		rightKeyMenuListener(jTree, editItem);
		JMenuItem deleteItem = new JMenuItem("ɾ����ǰĿ¼");
		rightKeyMenuListener(jTree, deleteItem);
		menu.add(equalItem);
		menu.add(downItem);
		menu.add(editItem);
		menu.add(deleteItem);
		return menu;
	}

	// �Ҽ��˵�����
	public void rightKeyMenuListener(final JTree jTree, JMenuItem item) {
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createEqualcontent(jTree, e);
				deleteCurrentcontent(jTree, e);
				createChildrenContent(jTree, e);
				editCurrentContent(jTree, e);
			}
		});
	}

	// �½�ͬ��Ŀ¼
	public void createEqualcontent(JTree jTree, ActionEvent e) {
		TreePath path = jTree.getSelectionPath();
		if (e.getActionCommand().equals("����ͬ��Ŀ¼")) {
			TreePath parentPath = path.getParentPath();
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) parentPath
					.getLastPathComponent();
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("�½ڵ�");
			node.add(newNode);

			// ���ýڵ�������ݿ�
			insertDatabaseOfNewNode(jTree, parentPath, newNode,"����ͬ��Ŀ¼");

			// ˢ���½��ڵ�����
			DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
			TreeNode[] nodes = model.getPathToRoot(newNode);
			TreePath treePath = new TreePath(nodes);
			jTree.scrollPathToVisible(treePath);
			jTree.updateUI();
		}
	}
	//������Ŀ¼
	public void createChildrenContent(JTree jTree,ActionEvent e){
		TreePath path=jTree.getSelectionPath();
		if(e.getActionCommand().equals("������һ��Ŀ¼")){
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
					.getLastPathComponent();
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("�½ڵ�");
			node.add(newNode);
			// ���ýڵ�������ݿ�
			insertDatabaseOfNewNode(jTree, path, newNode,"������һ��Ŀ¼");
			// ˢ���½��ڵ�����
			DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
			TreeNode[] nodes = model.getPathToRoot(newNode);
			TreePath treePath = new TreePath(nodes);
			jTree.scrollPathToVisible(treePath);
			jTree.updateUI();
		}
	}
	//�༭��ǰ�ڵ�
	public void editCurrentContent(JTree jTree, ActionEvent e){
		TreePath path = jTree.getSelectionPath();
		if (e.getActionCommand().equals("�༭��ǰĿ¼")) {
			if(path!=null){
				jTree.startEditingAtPath(path);
			System.out.println("00000");
			jTree.getCellEditor().addCellEditorListener(new CellEditorListener(){

				public void editingCanceled(ChangeEvent e) {
					JOptionPane.showMessageDialog(null,"�༭ʧ��! �༭��ɺ��밴  enter��ȷ��");
				}

				public void editingStopped(ChangeEvent e) {
					
				}
				
			});
			}
		}
	}
	
	//ɾ����ǰĿ¼
	public void deleteCurrentcontent(JTree jTree, ActionEvent e){
		TreePath path = jTree.getSelectionPath();
		if (e.getActionCommand().equals("ɾ����ǰĿ¼")) {
			MedicineClassifyService mcf = new MedicineClassifyServiceImpl();
			MedicineClassify classify=getSelectedNodeInformation(path);
			try {
				mcf.deleteMedicineClassify(classify);
			} catch (DeleteObjectException e1) {
				e1.printStackTrace();
			}
			DefaultMutableTreeNode selectedNode=(DefaultMutableTreeNode) path.getLastPathComponent();
			DefaultTreeModel model=(DefaultTreeModel) jTree.getModel();
			if(selectedNode!=null&&selectedNode.getParent()!=null){
				model.removeNodeFromParent(selectedNode);
			}
		}
	}

	// �����ݿ�����½��ڵ��ֵ
	public void insertDatabaseOfNewNode(JTree jTree, TreePath parentPath,
			DefaultMutableTreeNode newNode,String judge) {
		MedicineClassifyService mcf = new MedicineClassifyServiceImpl();
		List<MedicineClassify> classifyList = null;
		int id = 0;
		try {
			classifyList = mcf.theLargestNumberOfMedicineClassify(null);
			id = classifyList.get(0).getId();
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
		MedicineClassify classify = getSelectedNodeInformation(parentPath);
		if(judge.equals("����ͬ��Ŀ¼")){
			classify.setId(id + 1);
		}else if(judge.equals("������һ��Ŀ¼")){
			classify.setPid(classify.getId());
			classify.setId(id+1);
		}
		classify.setName(newNode.toString());
		try {
			mcf.addMedicineClassify(classify);
		} catch (AddObjectException e) {
			e.printStackTrace();
		}
	}

	// �ݹ鴴����
	public void recursionCreateMedicineClassifyTree(
			MedicineClassifyService mcf, MedicineClassify classify,
			DefaultMutableTreeNode node) throws QueryObjectException {
		List<MedicineClassify> classifyList = mcf.getChildren(classify);
		if (!classifyList.isEmpty()) {
			for (MedicineClassify mc : classifyList) {
				DefaultMutableTreeNode childrenNode = new DefaultMutableTreeNode(
						mc.getName());
				node.add(childrenNode);
				recursionCreateMedicineClassifyTree(mcf, mc, childrenNode);
			}
		}
	}
}
