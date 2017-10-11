package cn.scxh.ittx.ui.shared;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.domain.Medicine;
import cn.scxh.ittx.domain.Patient;
import cn.scxh.ittx.domain.SickCase;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;
import cn.scxh.ittx.service.impl.MedicineServiceImpl;
import cn.scxh.ittx.service.impl.PatientServiceImpl;
import cn.scxh.ittx.service.impl.SickCaseServiceImpl;
import cn.scxh.ittx.service.intf.MedicineService;
import cn.scxh.ittx.service.intf.PatientService;
import cn.scxh.ittx.service.intf.SickCaseService;
import cn.scxh.ittx.util.SharedModel;

public class SetValueOfUI {
	private Map<String, DifferenceComponent> dcMap = new HashMap<String, DifferenceComponent>();
	private DifferenceObject object;

	public SetValueOfUI() {
	}

	public SetValueOfUI(DifferenceObject object) {
		this.object = object;
	}

	private static SetValueOfUI setValue;

	public synchronized static SetValueOfUI getInstance(DifferenceObject object) {
		if (setValue == null) {
			setValue = new SetValueOfUI(object);
		}
		return setValue;
	}

	public void setLoginErrorResponse(Map<String, String> loginValidateError) {
		Set<Entry<String, String>> entrySet = loginValidateError.entrySet();
		String message = null;
		for (Entry<String, String> entry : entrySet) {
			if ("userNameError".equals(entry.getKey())) {
				message = entry.getValue();
			}
			if ("passwordError".equals(entry.getKey())) {
				if (message != null) {
					message = message + " " + entry.getValue();
				} else {
					message = entry.getValue();
				}
			}
		}
		JOptionPane.showMessageDialog(null, message);
	}

	// Ϊ��������ֵ
	public void settabbedPaneJPanel1ContextComponent() {

		PatientService ps = new PatientServiceImpl();
		List<Patient> patientList = null;
		try {
			patientList = ps.theLargestNumberOfPatients();
			if (!patientList.isEmpty()) {
				String frontSubstring = patientList.get(0).getId().substring(0,
						8);
				String afterSubstring = patientList.get(0).getId().substring(8);
				Date date = new Date();
				String dateString = new SimpleDateFormat("yyyy-MM-dd")
						.format(date);
				String[] dateArray = dateString.split("-");
				String s = null;
				for (String string : dateArray) {
					if (s == null) {
						s = string;
					} else {
						s = s + string;
					}
				}
				if (frontSubstring.equals(s)) {
					String id = s
							+ String
									.valueOf(Integer.parseInt(afterSubstring) + 1);
					object.getJtextFieldMap().get("ҽ��֤��:").setText(id);
				} else {
					String id = s + 1;
					object.getJtextFieldMap().get("ҽ��֤��:").setText(id);
				}
			}
		} catch (QueryObjectException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "��ѯʱ������!!");
		}
		object.setFlag("_001");
	}

	// �õ�Id��

	public void setUpdateValue(List<Patient> patientList) {
		Patient patient = patientList.get(0);
		object.getJtextFieldMap().get("ҽ��֤��:").setText(patient.getId());
		object.getJtextFieldMap().get("��������:").setText(patient.getName());
		String sex = patient.getSex().trim();
		int number = object.getJcomboBoxMap().get("��        ��:").getItemCount();
		for (int i = 0; i < number; i++) {
			String se = (String) object.getJcomboBoxMap().get("��        ��:")
					.getItemAt(i);
			if (sex.equals(se)) {
				object.getJcomboBoxMap().get("��        ��:").setSelectedIndex(i);
			}
		}
		object.getJtextFieldMap().get("��        ��:").setText(
				String.valueOf(patient.getAge()));
		String married = patient.getMarried().trim();
		int marriedNumber = object.getJcomboBoxMap().get("����״��:")
				.getItemCount();
		for (int i = 0; i < marriedNumber; i++) {
			String se = (String) object.getJcomboBoxMap().get("����״��:")
					.getItemAt(i);
			if (married.equals(se)) {
				object.getJcomboBoxMap().get("����״��:").setSelectedIndex(i);
			}
		}
		String job = patient.getJob().trim();
		int jobNumber = object.getJcomboBoxMap().get("ְ        ҵ:")
				.getItemCount();
		for (int i = 0; i < jobNumber; i++) {
			String se = (String) object.getJcomboBoxMap().get("ְ        ҵ:")
					.getItemAt(i);
			if (job.equals(se)) {
				object.getJcomboBoxMap().get("ְ        ҵ:").setSelectedIndex(i);
			}
		}
		if (patient.getBlood() != null) {
			String blood = patient.getBlood().trim();
			int bloodNumber = object.getJcomboBoxMap().get("Ѫ        ��:")
					.getItemCount();
			for (int i = 0; i < bloodNumber; i++) {
				String se = (String) object.getJcomboBoxMap()
						.get("Ѫ        ��:").getItemAt(i);
				if (blood.equals(se)) {
					object.getJcomboBoxMap().get("Ѫ        ��:")
							.setSelectedIndex(i);
				}
			}
		}
		object.getJtextFieldMap().get("��        ��:").setText(
				String.valueOf(patient.getWeight()));
		object.getJtextFieldMap().get("��ϵ�绰:")
				.setText(patient.getPhoneNumber());
		object.getJtextFieldMap().get("�Ǽ�����:").setText(
				DateFormat.getDateInstance().format(patient.getRegisterTime()));
		object.getJtextFieldMap().get("��ϵ��ַ:").setText(patient.getAddress());
		object.getJtextFieldMap().get(" �� �� ʷ :").setText(patient.getAllergy());
		object.getJtextFieldMap().get("��        ע:").setText(
				patient.getRemark());
		object.setFlag("_002");
	}

	public void setValueOfJPanel21(List<Patient> patientList) {
		Patient patient = null;
		if (patientList != null) {
			patient = patientList.get(0);
		}
		DifferenceObject o = object.getDifferenceObjectMap().get(
				"jPanel21Object");
		JPanel jPanel21 = o.getJpanel();

		if (!dcMap.containsKey("id")) {
			DifferenceComponent dc = new DifferenceComponent(o);
			dc
					.jLabelComponent(jPanel21, patient.getId(), 70, 70, 100,
							20, "id");
			dcMap.put("id", dc);
		} else {
			dcMap.get("id").jLabelComponent(jPanel21, patient.getId(), 70, 70,
					100, 20, "id");
		}
		if (!dcMap.containsKey("Name")) {
			DifferenceComponent dc = new DifferenceComponent(o);
			dc.jLabelComponent(jPanel21, patient.getName(), 230, 70, 100, 20,
					"name");
			dcMap.put("Name", dc);
		} else {
			dcMap.get("Name").jLabelComponent(jPanel21, patient.getName(), 230,
					70, 100, 20, "name");
		}
		if (!dcMap.containsKey("sex")) {
			DifferenceComponent dc = new DifferenceComponent(o);
			dc.jLabelComponent(jPanel21, patient.getSex(), 390, 70, 100, 20,
					"sex");
			dcMap.put("sex", dc);
		} else {
			dcMap.get("sex").jLabelComponent(jPanel21, patient.getSex(), 390,
					70, 100, 20, "sex");
		}
		if (!dcMap.containsKey("age")) {
			DifferenceComponent dc = new DifferenceComponent(o);
			dc.jLabelComponent(jPanel21, patient.getAge() + "", 550, 70, 100,
					20, "age");
			dcMap.put("age", dc);
		} else {
			dcMap.get("age").jLabelComponent(jPanel21,
					String.valueOf(patient.getAge()), 550, 70, 100, 20, "age");
		}
		// o.getJtextFieldMap().get("��������").setText(DateFormat.getDateInstance().format(new
		// Date()));
		jPanel21.updateUI();
	}

	public void setIsEnabledOfButton(boolean b) {
		object.getJbuttonMap().get("_001").setEnabled(b);
		object.getJbuttonMap().get("_002").setEnabled(b);
		object.getJbuttonMap().get("_003").setEnabled(b);
		object.getJbuttonMap().get("_004").setEnabled(!b);
		object.getJbuttonMap().get("_005").setEnabled(!b);

	}

	// ��JPanel21�е�Table�л��id
	public void comeBackDataFromJPanel21() {
		DifferenceObject o = object.getDifferenceObjectMap().get(
				"jPanel21Object");
		JTable jTable = o.getJtable();
		setListenerOfJPanel21Table();
		int i = jTable.getSelectedRow();

		// TODO ��������д�
		// jTable.setRowSelectionInterval(0, 0);
		String id = null;
		if (i == -1) {
			try {
				id = (String) jTable.getValueAt(0, 0);
			} catch (Exception e) {
				// e.printStackTrace();
				isEmptyToJPanel21();
			}
		} else {
			try {
				id = (String) jTable.getValueAt(i, 0);
			} catch (Exception e) {
				// e.printStackTrace();
				try {
					id = (String) jTable.getValueAt(0, 0);
				} catch (Exception e1) {
					// e1.printStackTrace();
				}
			}
		}
		if (id != null) {
			SickCase sickCase = new SickCase();
			sickCase.setId(Integer.parseInt(id));
			SickCaseService scs = new SickCaseServiceImpl();
			try {
				List<SickCase> sickCaseList = scs
						.differenceConditionQuerySickCase(sickCase);
				setDataToJPanel21(sickCaseList);
			} catch (QueryObjectException e) {
				e.printStackTrace();
			}
		}
	}

	// ��JPanel21��JTable��������
	private void setListenerOfJPanel21Table() {
		DifferenceObject o = object.getDifferenceObjectMap().get(
				"jPanel21Object");
		final JTable jTable = o.getJtable();
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = jTable.getSelectedRow();
				if (i == -1) {
					JOptionPane.showMessageDialog(null, "��!��ѡ��һ����¼.");
				} else {
					String id = (String) jTable.getValueAt(i, 0);
					if (id != null) {
						SickCase sickCase = new SickCase();
						sickCase.setId(Integer.parseInt(id));
						SickCaseService scs = new SickCaseServiceImpl();
						try {
							List<SickCase> sickCaseList = scs
									.differenceConditionQuerySickCase(sickCase);
							setDataToJPanel21(sickCaseList);
						} catch (QueryObjectException e1) {
							e1.printStackTrace();
						}
					}
				}

			}
		});
	}

	// ���JPanel21�е�����
	public void isEmptyToJPanel21() {
		DifferenceObject o = object.getDifferenceObjectMap().get(
				"jPanel21Object");
		o.getJtextFieldMap().get("��         ��:").setText("");
		o.getJtextFieldMap().get("��  ��  ʷ:").setText("");
		o.getJtextFieldMap().get("��  ��  ʷ:").setText("");
		o.getJtextFieldMap().get("��  ��  ʷ:").setText("");
		o.getJtextFieldMap().get("�����:").setText("");
		o.getJtextFieldMap().get("ʵ����:").setText("");
		o.getJtextFieldMap().get("���:").setText("");
		o.getJtextFieldMap().get("�������:").setText("");
		o.getJtextFieldMap().get("����˵��:").setText("");
		o.getJtextFieldMap().get("��������").setText("");
	}

	// �������ݵ�JPanel21�ı���
	private void setDataToJPanel21(List<SickCase> sickCaseList) {
		DifferenceObject o = object.getDifferenceObjectMap().get(
				"jPanel21Object");
		if (!sickCaseList.isEmpty()) {
			SickCase sickCase = sickCaseList.get(0);
			o.getJtextFieldMap().get("��         ��:").setText(
					sickCase.getMainSymptom());
			o.getJtextFieldMap().get("��  ��  ʷ:").setText(
					sickCase.getNowSymptom());
			o.getJtextFieldMap().get("��  ��  ʷ:").setText(
					sickCase.getPastSymptom());
			o.getJtextFieldMap().get("��  ��  ʷ:").setText(
					sickCase.getPersonalSymptom());
			o.getJtextFieldMap().get("�����:").setText(sickCase.getBodyTest());
			o.getJtextFieldMap().get("ʵ����:").setText(sickCase.getLabTest());
			o.getJtextFieldMap().get("���:").setText(sickCase.getExamination());
			o.getJtextFieldMap().get("�������:").setText(sickCase.getAdvice());
			o.getJtextFieldMap().get("����˵��:").setText(
					sickCase.getOtherExplain());
			o.getJtextFieldMap().get("��������").setText(
					DateFormat.getDateInstance().format(
							sickCase.getExaminationTime()));

		}
	}

	// ��JPanel21�е������ʱ��ת������ҳ��
	public void setSkipToAddJPanel21() {
		DifferenceObject object1 = object.getDifferenceObjectMap()
				.get("object");
		SetValueOfUI setValue = new SetValueOfUI(object1);
		setValue.isEmptyToJPanel21();
		object.getJtextFieldMap().get("��������").setText(
				DateFormat.getDateInstance().format(new Date()));

	}

	// ȷ���޸Ķ�ӦJPanel21�Ľ���
	public void confirmUpdateOfJPanel21() {
		JTable jTable = object.getJtable();
		int i = jTable.getSelectedRow();
		String id = (String) jTable.getValueAt(i, 0);
		int j = JOptionPane.showConfirmDialog(null, "ȷ���޸���?", "����", 0, 0, null);
		if (j == 0) {
			SickCaseService scs = new SickCaseServiceImpl();
			SickCase sickCase = new SickCase();
			sickCase.setId(Integer.parseInt(id));
			GetValueOfUI value = new GetValueOfUI(object);
			value.getDateValueFromJPanel21(sickCase);

			try {
				scs.updateSickCase(sickCase);
			} catch (UpdateObjectException e) {
				e.printStackTrace();
			}

			value.updateJTableOfJPanel21();
		}

	}

	// ����ɾ������JPanel21
	public void setDeleteOfJPanel21() {
		JTable jTable = object.getJtable();
		if (jTable == null) {
			JOptionPane.showMessageDialog(null, "��!���ڲ��˱���ѡ��һ���ͻ�");
		} else {
			int j = jTable.getRowCount();
			if (j == 0) {
				JOptionPane.showMessageDialog(null, "��!���û�û�в���,�����޸�.");
			} else {
				int[] i = jTable.getSelectedRows();
				if (i.length == 0) {
					JOptionPane.showMessageDialog(null, "��!������ѡ��һ����¼");
				} else {
					int l = JOptionPane.showConfirmDialog(null, "��!ȷ��ɾ����?",
							"ɾ��", 0, 0, null);
					if (l == 0) {
						// setIsEnabledOfButton(false);
						for (int k = 0; k < i.length; k++) {
							String id = (String) jTable.getValueAt(k, 0);
							SickCaseService scs = new SickCaseServiceImpl();
							SickCase sc = new SickCase();
							sc.setId(Integer.parseInt(id));
							try {
								scs.deleteSickCase(sc);
							} catch (DeleteObjectException e) {
								e.printStackTrace();
							}
						}
						GetValueOfUI value = new GetValueOfUI(object);
						value.updateJTableOfJPanel21();
					}
				}
			}
		}
	}

	// ����JPanel9�е�ֵ
	public void setDataToJPanel9(int id) {

		MedicineService ms = new MedicineServiceImpl();
		Medicine m = new Medicine();
		m.setId(id);
		List<Medicine> medicineList = null;
		try {
			medicineList = ms.differenceConditionQueryMedicines(m);
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
		m = medicineList.get(0);
		object.getJtextFieldMap().get("ҩƷ���:").setText(m.getId() + "");
		object.getJtextFieldMap().get("ҩƷ����:").setText(m.getName());
		// object.getJcomboBoxMap().get("ҩƷ���:")

		object.getJtextFieldMap().get("ҩƷ���:").setText(m.getStandard());
		// object.getJcomboBoxMap().get("������λ:")

		object.getJtextFieldMap().get("ҩƷ����:").setText(m.getEnterPrice());
		object.getJtextFieldMap().get("�ɱ��۸�:").setText(m.getShoppingPrice());
		object.getJtextFieldMap().get("���α���:").setText(
				m.getValidateNumber() + "");
		object.getJtextFieldMap().get("���ۼ۸�:").setText(m.getSalePrice() + "");
		object.getJtextFieldMap().get("ҩƷ��ƴ:").setText(m.getSimpleName());
		object.getJtextFieldMap().get("�������:").setText(m.getUpperLimit());
		object.getJtextFieldMap().get("�������:").setText(m.getDownLimit());
		object.getJtextFieldMap().get("��׼�ĺ�:").setText(m.getApproveNumber());
		object.getJtextFieldMap().get("���ɳ���:").setText(m.getProduceCompany());
		object.getJtextFieldMap().get("��Ҫ�ɷ�:").setText(m.getMainComponent());
		object.getJtextFieldMap().get("����Ч:").setText(m.getMedicineEffect());
		object.getJtextFieldMap().get("ʹ�÷���:").setText(m.getUseMethod());
		object.getJtextFieldMap().get("ע������:").setText(
				m.getMattersNeedAttention());
	}

	public int isSelectedOfJPanel7() {

		DifferenceObject object7 = null;
		if (object.getDifferenceObjectMap().get("object7") == null) {
			object7 = object.getDifferenceObjectMap().get("object5")
					.getDifferenceObjectMap().get("object7");
		} else {
			object7 = object.getDifferenceObjectMap().get("object7");
		}
		JTable jTable = object7.getJtable();
		int i = jTable.getSelectedRow();
		int id = 0;
		if (i == -1) {
			JOptionPane.showMessageDialog(null, "��!�㻹û��ѡ��Ҫ�޸Ļ�ɾ���ļ�¼");

		} else {
			id = Integer.parseInt((String) jTable.getValueAt(i, 0));
		}
		return id;
	}

	public void setDeleteFromJPanel7(int id) {
		DifferenceObject object7=object.getDifferenceObjectMap().get("object7");
		Medicine medicine = new Medicine();
		medicine.setId(id);
		MedicineService ms = new MedicineServiceImpl();
		try {
			ms.deleteMedicine(medicine);
		} catch (DeleteObjectException e) {
			e.printStackTrace();
		}

		SharedModel sharedModel = object7.getSharedModel();
		try {
			sharedModel.setPatientArrays(ms.queryMedicines(null));
			object7.getJtable().updateUI();

		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
	}

}
