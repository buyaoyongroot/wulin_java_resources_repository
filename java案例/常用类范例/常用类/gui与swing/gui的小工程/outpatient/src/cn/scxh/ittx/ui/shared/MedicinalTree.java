package cn.scxh.ittx.ui.shared;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import cn.scxh.ittx.dao.impl.MedicineDaoImpl;
import cn.scxh.ittx.dao.intf.MedicineDao;
import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.domain.Medicine;
import cn.scxh.ittx.domain.SharedArrays;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.util.ConstantUtils;
import cn.scxh.ittx.util.SharedModel;

public class MedicinalTree {
	List<DefaultMutableTreeNode> sharedNodeList = new ArrayList<DefaultMutableTreeNode>();
	private DifferenceObject object;

	public MedicinalTree() {
	}

	public MedicinalTree(DifferenceObject object) {
		this.object = object;
	}

	// ������
	public void createTree(JPanel jPanel6) {
		DifferenceObject object6=new DifferenceObject();
		object.getDifferenceObjectMap().put("jPanel6", object6);
		object6.getDifferenceObjectMap().put("jPanel5", object);
		object6.getDifferenceObjectMap().put("object7", object.getDifferenceObjectMap().get("object7"));
		object.getDifferenceObjectMap().get("object7").getDifferenceObjectMap().put("object6",object6);
		object6.setJpanel(jPanel6);
		jPanel6.setLayout(null);
		DefaultMutableTreeNode node1;
		node1 = oneNode();

		JTree jTree = new JTree(node1);
		// jTree.setEnabled(true);
		jTree.setEditable(true);
		jTree.setBounds(0, 0, 800, 600);
		autoGetData(jTree);
		treeMouseListener(jTree);

		jPanel6.add(jTree);
	}

	// �Զ���ȡ����
	public void autoGetData(JTree jTree) {
		DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
		DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) model.getRoot();

		isRecursionQuery(jTree,node1);
		showTableData(sharedNodeList);
	}

	// ��ʾ������
	public void showTableData(List<DefaultMutableTreeNode> sharedNodeList2) {
		DifferenceObject object7=object.getDifferenceObjectMap().get("object7");
		SharedModel sharedModel=new SharedModel();
		object7.setSharedModel(sharedModel);
		try {
			sharedModel.setPatientArrays(queryMedicines(sharedNodeList2));
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
		JTable jTable7=new JTable(sharedModel);
		object7.setJtable(jTable7);
		JScrollPane jScrollPane=new JScrollPane(jTable7);
		jScrollPane.setBounds(0,0,ConstantUtils.WIDTH-ConstantUtils.WIDTH/4-225,ConstantUtils.HEIGHT-ConstantUtils.HEIGHT/6-160);
		
		JPanel jPanel7=object7.getJpanel();
		jPanel7.add(jScrollPane);
		
	}

	//����ת������
	public SharedArrays queryMedicines(List<DefaultMutableTreeNode> sharedNodeList2)
			throws QueryObjectException {
		String[] oneArray = new String[] { "���", "����", "ҩƷ���", "ҩƷ���", "���ڵ�λ",
				"���ڼ۸�", "�ɱ��۸�", "��֤��", "���ۼ۸�", "������", "�������", "�������", "��׼���",
				"������˾", "��Ҫ�ɷ�", "ҩƷ��Ч", "ʹ�÷���", "ע������" };
		SharedArrays sharedArrays = new SharedArrays();
		List<List<Medicine>> listList=new ArrayList<List<Medicine>>();
		MedicineDao md = new MedicineDaoImpl();
		Medicine medicine=new Medicine();
		try{
		int sum=0;
		int i=0;
		for(DefaultMutableTreeNode node:sharedNodeList2){
			medicine.setClassification(node.toString());
			List<Medicine> medicineList = md.differenceConditionQueryMedicines(medicine);
			sum=sum+medicineList.size();
			listList.add(medicineList);
		}
		String[][] twoArray = new String[sum][oneArray.length];
		for(List<Medicine> medicineList : listList){
			for (Medicine m : medicineList) {
				twoArray[i][0] = String.valueOf(m.getId());
				twoArray[i][1] = m.getName();
				twoArray[i][2] = m.getClassification();
				twoArray[i][3] = m.getStandard();
				twoArray[i][4] = m.getEnterCompany();
				twoArray[i][5] = m.getEnterPrice();
				twoArray[i][6] = m.getShoppingPrice();
				twoArray[i][7] = m.getValidateNumber() + "";
				twoArray[i][8] = m.getSalePrice() + "";
				twoArray[i][9] = m.getSimpleName();
				twoArray[i][10] = m.getUpperLimit();
				twoArray[i][11] = m.getDownLimit();
				twoArray[i][12] = m.getApproveNumber() + "";
				twoArray[i][13] = m.getProduceCompany();
				twoArray[i][14] = m.getMainComponent();
				twoArray[i][15] = m.getMedicineEffect();
				twoArray[i][16] = m.getUseMethod();
				twoArray[i][17] = m.getMattersNeedAttention();
				i++;
			}
		}
			sharedArrays.setSharedOneArray(oneArray);
			sharedArrays.setSharedTwoArray(twoArray);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new QueryObjectException();
		}
		sharedNodeList.clear();
		return sharedArrays;
	}

	//��һ���ڵ���Ҷ�ӽڵ��ѯ
	public void isRecursionQuery(JTree jTree,DefaultMutableTreeNode node){
		if(node.isLeaf()){
			sharedNodeList.add(node);
		}else{
			recursionquery(jTree,node);
		}
	}
	
	// �ݹ��ѯ
	public void recursionquery(JTree jTree, DefaultMutableTreeNode node) {
		if (!node.isLeaf()) {
			DefaultMutableTreeNode node1 = node.getNextNode();
			recursionquery(jTree, node1);
			node = node.getNextSibling();
			if (node != null) {
				recursionquery(jTree, node);
			}
		} else {
			sharedNodeList.add(node);
			node = node.getNextSibling();
			if (node != null) {
				recursionquery(jTree, node);
			}
		}
	}

	// tree��������
	public void treeMouseListener(final JTree jTree) {
		jTree.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				TreePath path=jTree.getPathForLocation(e.getX(), e.getY());
				if(path!=null){
					DefaultMutableTreeNode node=(DefaultMutableTreeNode)path.getLastPathComponent();
					isRecursionQuery(jTree,node);
				}
				DifferenceObject object7=object.getDifferenceObjectMap().get("object7");
				SharedModel sharedModel=object7.getSharedModel();
				
				try {
					sharedModel.setPatientArrays(queryMedicines(sharedNodeList));
					object7.getJtable().updateUI();
				} catch (QueryObjectException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	// һ���ڵ�
	public DefaultMutableTreeNode oneNode() {
		DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("ҩƷ����");

		twoNode(node1);
		return node1;
	}

	// �����ڵ�
	public List<DefaultMutableTreeNode> twoNode(DefaultMutableTreeNode node1) {
		List<DefaultMutableTreeNode> node2List = new ArrayList<DefaultMutableTreeNode>();
		DefaultMutableTreeNode node21 = new DefaultMutableTreeNode("�Է���");
		DefaultMutableTreeNode node22 = new DefaultMutableTreeNode("������");

		node1.add(node21);
		node1.add(node22);

		node2List.add(node21);
		node2List.add(node22);
		threeNode(node2List);
		return node2List;
	}

	// �����ڵ�
	public List<DefaultMutableTreeNode> threeNode(
			List<DefaultMutableTreeNode> node2List) {
		List<DefaultMutableTreeNode> node3List = new ArrayList<DefaultMutableTreeNode>();
		DefaultMutableTreeNode node31 = new DefaultMutableTreeNode("Ƥ���Ƴ���ҩ");
		DefaultMutableTreeNode node32 = new DefaultMutableTreeNode("Ƥ������ҩ");
		DefaultMutableTreeNode node33 = new DefaultMutableTreeNode("��ҩ�ɷ�����ҩ");
		DefaultMutableTreeNode node34 = new DefaultMutableTreeNode("��ҩ�ɷ�����ҩ");
		DefaultMutableTreeNode node35 = new DefaultMutableTreeNode("�ڿ���ҩ");
		DefaultMutableTreeNode node36 = new DefaultMutableTreeNode("������ҩ");
		DefaultMutableTreeNode node37 = new DefaultMutableTreeNode("�г�ҩ");
		DefaultMutableTreeNode node38 = new DefaultMutableTreeNode("�շ���Ŀ");
		DefaultMutableTreeNode node39 = new DefaultMutableTreeNode("����Ʒ��");

		DefaultMutableTreeNode node21 = node2List.get(0);

		node21.add(node31);
		node21.add(node32);
		node21.add(node33);
		node21.add(node34);
		node21.add(node35);
		node21.add(node36);
		node21.add(node37);
		node21.add(node38);
		node21.add(node39);

		node3List.add(node31);
		node3List.add(node32);
		node3List.add(node33);
		node3List.add(node34);
		node3List.add(node35);
		node3List.add(node36);
		node3List.add(node37);
		node3List.add(node38);
		node3List.add(node39);

		return node3List;
	}

}
