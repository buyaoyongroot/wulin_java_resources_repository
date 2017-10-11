package cn.scxh.ittx.ui.shared;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cn.scxh.ittx.domain.DifferenceObject;
import cn.scxh.ittx.domain.Medicine;
import cn.scxh.ittx.domain.Patient;
import cn.scxh.ittx.domain.SickCase;
import cn.scxh.ittx.domain.User;
import cn.scxh.ittx.exception.AddObjectException;
import cn.scxh.ittx.exception.DeleteObjectException;
import cn.scxh.ittx.exception.QueryObjectException;
import cn.scxh.ittx.exception.UpdateObjectException;
import cn.scxh.ittx.service.impl.MedicineServiceImpl;
import cn.scxh.ittx.service.impl.PatientServiceImpl;
import cn.scxh.ittx.service.impl.SickCaseServiceImpl;
import cn.scxh.ittx.service.intf.MedicineService;
import cn.scxh.ittx.service.intf.PatientService;
import cn.scxh.ittx.service.intf.SickCaseService;
import cn.scxh.ittx.ui.form.FormLoginValidate;
import cn.scxh.ittx.ui.hospitalFrame.HospitalHomePageFrame;
import cn.scxh.ittx.util.SharedModel;

public class GetValueOfUI {
	private DifferenceObject object;

	public GetValueOfUI() {
	}

	public GetValueOfUI(DifferenceObject object) {
		this.object = object;
	}

	public void getFirstConfirmValue() {
		User user = new User();
		user.setName(object.getJtextFieldMap().get("�û���:").getText());
		user.setPassword(String.valueOf(object.getJpasswordField()
				.getPassword()));
		FormLoginValidate flv = new FormLoginValidate();
		Map<String, String> loginValidateError = flv.userLoginValidate(user);
		if (loginValidateError != null) {
			SetValueOfUI setValue = new SetValueOfUI(object);
			setValue.setLoginErrorResponse(loginValidateError);
		} else {
			object.getJframe().setVisible(false);
			HospitalHomePageFrame hhpf = new HospitalHomePageFrame();
			hhpf.hospitalHomePage();

		}
	}

	public Patient getTabbedPaneJPanel1ContextComponent() {
		Patient patient = new Patient();
		patient.setId(object.getJtextFieldMap().get("ҽ��֤��:").getText());
		System.out.println(object.getJtextFieldMap().get("ҽ��֤��:").getText());
		patient.setName(object.getJtextFieldMap().get("��������:").getText());
		patient.setSex((String) object.getJcomboBoxMap().get("��        ��:")
				.getSelectedItem());
		patient.setBlood((String) object.getJcomboBoxMap().get("Ѫ        ��:")
				.getSelectedItem());
		try {
			patient.setAge(Integer.parseInt(object.getJtextFieldMap().get(
					"��        ��:").getText()));
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "��!���䲻��Ϊ�ջ�������ַ�.");
		}
		patient.setMarried((String) object.getJcomboBoxMap().get("����״��:")
				.getSelectedItem());
		patient.setJob((String) object.getJcomboBoxMap().get("ְ        ҵ:")
				.getSelectedItem());
		try {
			patient.setWeight(Integer.parseInt(object.getJtextFieldMap().get(
					"��        ��:").getText()));
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "��!���ز���Ϊ�ջ�������ַ�.");
		}
		patient
				.setPhoneNumber(object.getJtextFieldMap().get("��ϵ�绰:")
						.getText());
		try {
			patient.setRegisterTime(DateFormat.getDateInstance().parse(
					new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		patient.setAddress(object.getJtextFieldMap().get("��ϵ��ַ:").getText());
		patient.setAllergy(object.getJtextFieldMap().get(" �� �� ʷ :").getText());
		patient.setRemark(object.getJtextFieldMap().get("��        ע:")
				.getText());
		return patient;
	}

	public void addValue(Patient patient) {
		PatientService ps = new PatientServiceImpl();
		try {
			ps.addPatient(patient);
		} catch (AddObjectException e1) {
			e1.printStackTrace();
		}
		try {
			ps.queryPatients(null);
			object.getSharedModel().setPatientArrays(ps.queryPatients(null));
			object.getJtable().updateUI();
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
	}

	// �õ�table�е�ѡ��ֵ
	public List<Patient> updateTabbedPaneJPanel1ContextComponent() {
		JTable jTable = object.getJtable();
		int i = jTable.getSelectedRow();
		List<Patient> patientList = null;
		if (i == -1) {
			JOptionPane.showMessageDialog(null, "��ѡ��һ��");
		} else {
			String id = (String) jTable.getValueAt(i, 0);
			PatientService ps = new PatientServiceImpl();

			Patient patient = new Patient();
			patient.setId(id);
			try {
				patientList = ps.differenceConditionQueryPatients(patient);
			} catch (QueryObjectException e) {
				e.printStackTrace();
			}
		}
		return patientList;
	}

	// �õ�bottonLeftJPanel�е�table�е�ѡ��ֵ ,����ѡ��������������
	public void getTabbedSelectedValue() {
		final JTable jTable = object.getJtable();
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				int i = jTable.getSelectedRow();
				if (i != -1) {
					String id = (String) jTable.getValueAt(i, 0);
					PatientService ps = new PatientServiceImpl();
					object.setId(id);
					Patient patient = new Patient();
					patient.setId(id);
					try {
						List<Patient> patientList = ps
								.differenceConditionQueryPatients(patient);

						SetValueOfUI.getInstance(object).setValueOfJPanel21(
								patientList);
					} catch (QueryObjectException e1) {
						e1.printStackTrace();
					}
				}
				getTableOfJPanel21();
			}

		});
	}

	// �����ݿ��л��ҩ���������
	public String[] getMedicineClassification() {
		String[] classification = new String[] { "Ƥ���Ƴ���ҩ", "Ƥ������ҩ", "��ҩ�ɷ�����ҩ",
				"��ҩ�ɷ�����ҩ", "�ڿ���ҩ", "������ҩ", "�г�ҩ", "�շ���Ŀ", "����Ʒ��", "������" };

		return classification;
	}

	// �����ݿ��л��ҩ���������
	public String[] getMedicineUnit() {
		String[] unit = new String[] { "��", "��", "��", "ǧ��", "֧", "ƿ", "��", "u" };

		return unit;
	}

	// ��JPanel21����һ��JTable��
	private void getTableOfJPanel21() {
		try {
			DifferenceObject o = object.getDifferenceObjectMap().get(
					"jPanel21Object");
			JPanel jPanel21 = o.getJpanel();
			SickCaseService sc = new SickCaseServiceImpl();
			SickCase sickCase = new SickCase();
			sickCase.setPatientIdFk(object.getId());
			if (o.getJtable() == null && o.getSharedModel() == null) {
				SharedModel sharedModel = new SharedModel();
				sharedModel.setPatientArrays(sc.querySickCase(sickCase));
				JTable jTable = new JTable(sharedModel);
				o.setJtable(jTable);
				o.setSharedModel(sharedModel);
				JScrollPane jScrollPane = new JScrollPane(jTable);
				jScrollPane.setBounds(0, 450, 1000, 100);
				jPanel21.add(jScrollPane);

			} else {
				o.getSharedModel().setPatientArrays(sc.querySickCase(sickCase));
				o.getJtable().updateUI();
			}
			SetValueOfUI setValue = new SetValueOfUI(object);
			setValue.comeBackDataFromJPanel21();
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}

	}

	// �õ�Id���
	public String getLargestId(List<SickCase> variousList) {
		String id = null;
		if (!variousList.isEmpty()) {
			String frontSubstring = String.valueOf(variousList.get(0).getId())
					.substring(0, 8);
			String afterSubstring = String.valueOf(variousList.get(0).getId())
					.substring(8);
			Date date = new Date();
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(date);
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
				id = s + String.valueOf(Integer.parseInt(afterSubstring) + 1);
			} else {
				id = s + 1;
			}
		}
		return id;
	}

	public void updateValue(Patient patient) {
		PatientService ps = new PatientServiceImpl();
		try {
			ps.updatePatient(patient);
		} catch (UpdateObjectException e1) {
			e1.printStackTrace();
		}
		try {
			ps.queryPatients(null);
			object.getSharedModel().setPatientArrays(ps.queryPatients(null));
			object.getJtable().updateUI();
		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
	}

	public void deleteValue() {
		JTable jTable = object.getJtable();
		int[] i = jTable.getSelectedRows();
		if (i.length == 0) {
			JOptionPane.showMessageDialog(null, "������ѡ��һ��");
		} else {
			int j = JOptionPane.showConfirmDialog(null, "ȷ��ɾ����?", null, 0, 0);
			PatientService ps = new PatientServiceImpl();
			if (j == 0) {
				for (int k = 0; k < i.length; k++) {
					String id = (String) jTable.getValueAt(i[k], 0);
					Patient patient = new Patient();
					patient.setId(id);
					try {
						ps.deletePatient(patient);
					} catch (DeleteObjectException e) {
						e.printStackTrace();
					}
				}
				try {
					object.getSharedModel().setPatientArrays(
							ps.queryPatients(null));
					jTable.updateUI();
				} catch (QueryObjectException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ��JPanel21�л�ȡֵ�������ŵ����ݿ���
	public void getValueToJPane() {
		SickCaseService sc = new SickCaseServiceImpl();
		SickCase sickCase = new SickCase();
		try {
			List<SickCase> sickCaseList = sc.theLargestNumberOfSikeCase();
			if (!sickCaseList.isEmpty()) {
				sickCase.setId(Integer.parseInt(getLargestId(sickCaseList)));
			}
		} catch (QueryObjectException e1) {
			e1.printStackTrace();
		}
		getDateValueFromJPanel21(sickCase);

		try {
			sc.addSickCase(sickCase);
		} catch (AddObjectException e) {
			e.printStackTrace();
		}
		updateJTableOfJPanel21();
	}

	// ��JPanel21���л�ȡ��ֵ
	public void getDateValueFromJPanel21(SickCase sickCase) {
		sickCase.setMainSymptom(object.getJtextFieldMap().get("��         ��:")
				.getText());
		sickCase.setNowSymptom(object.getJtextFieldMap().get("��  ��  ʷ:")
				.getText());
		sickCase.setPastSymptom(object.getJtextFieldMap().get("��  ��  ʷ:")
				.getText());
		sickCase.setPersonalSymptom(object.getJtextFieldMap().get("��  ��  ʷ:")
				.getText());
		sickCase.setBodyTest(object.getJtextFieldMap().get("�����:").getText());
		sickCase.setLabTest(object.getJtextFieldMap().get("ʵ����:").getText());
		sickCase.setExamination(object.getJtextFieldMap().get("���:").getText());
		sickCase.setAdvice(object.getJtextFieldMap().get("�������:").getText());
		sickCase.setOtherExplain(object.getJtextFieldMap().get("����˵��:")
				.getText());
		try {
			sickCase.setExaminationTime(DateFormat.getDateInstance().parse(
					new SimpleDateFormat("yyyy-MM-dd").format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (object.getDifferenceObjectMap().get("object").getId() != null) {
			sickCase.setPatientIdFk(object.getDifferenceObjectMap().get(
					"object").getId());
		}
	}

	// ����JPanel21�ı�JTable
	public void updateJTableOfJPanel21() {
		SickCaseService scs = new SickCaseServiceImpl();
		try {
			SickCase sCase = new SickCase();
			sCase.setPatientIdFk(object.getDifferenceObjectMap().get("object")
					.getId());
			object.getSharedModel().setPatientArrays(scs.querySickCase(sCase));
			object.getJtable().updateUI();

		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
	}

	// ����JPanel21���е�ֵ
	public void updateDateOfJPanel21() {
		JTable jTable = object.getJtable();
		if (jTable == null) {
			JOptionPane.showMessageDialog(null, "��!���ڲ��˱���ѡ��һ���ͻ�");
		} else {
			int j = jTable.getRowCount();
			if (j == 0) {
				JOptionPane.showMessageDialog(null, "��!���û�û�в���,�����޸�.");
			} else {
				int i = jTable.getSelectedRow();
				if (i == -1) {
					JOptionPane.showMessageDialog(null, "��!��ѡ��һ����¼.");
				} else {
					SetValueOfUI setValue = new SetValueOfUI(object);
					setValue.setIsEnabledOfButton(false);
					object.setFlag("_002");
				}
			}
		}
	}
	
	//����õ�ֵ����
	public void getSharedValue(Medicine medicine){
		medicine.setId(Integer.parseInt(object.getJtextFieldMap().get("ҩƷ���:")
				.getText()));
		medicine.setName(object.getJtextFieldMap().get("ҩƷ����:").getText());
		medicine.setClassification((String) object.getJcomboBoxMap().get(
				"ҩƷ���:").getSelectedItem());
		medicine.setStandard(object.getJtextFieldMap().get("ҩƷ���:").getText());
		medicine.setEnterCompany((String) object.getJcomboBoxMap().get("������λ:")
				.getSelectedItem());
		System.out.println(object.getJcomboBoxMap().get("������λ:")
				.getSelectedItem());

		medicine
				.setEnterPrice(object.getJtextFieldMap().get("ҩƷ����:").getText());
		medicine.setShoppingPrice(object.getJtextFieldMap().get("�ɱ��۸�:")
				.getText());
		try {
			medicine.setValidateNumber(Integer.parseInt(object
					.getJtextFieldMap().get("���α���:").getText()));
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "��!���α���Ϊ�����Ҳ���Ϊ��");
			return;
			// e1.printStackTrace();
		}
		try {
			medicine.setSalePrice(Integer.parseInt(object.getJtextFieldMap()
					.get("���ۼ۸�:").getText()));
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "��!���ۼ۸�Ϊ�����Ҳ���Ϊ��");
			return;
			// e1.printStackTrace();
		}
		medicine
				.setSimpleName(object.getJtextFieldMap().get("ҩƷ��ƴ:").getText());
		medicine
				.setUpperLimit(object.getJtextFieldMap().get("�������:").getText());
		medicine.setDownLimit(object.getJtextFieldMap().get("�������:").getText());
		medicine.setApproveNumber(object.getJtextFieldMap().get("��׼�ĺ�:")
				.getText());
		medicine.setProduceCompany(object.getJtextFieldMap().get("���ɳ���:")
				.getText());
		medicine.setMainComponent(object.getJtextFieldMap().get("��Ҫ�ɷ�:")
				.getText());
		medicine.setMedicineEffect(object.getJtextFieldMap().get("����Ч:")
				.getText());
		medicine.setUseMethod(object.getJtextFieldMap().get("ʹ�÷���:").getText());
		medicine.setMattersNeedAttention(object.getJtextFieldMap().get("ע������:")
				.getText());

	}

	//��JPanel8�ı��еõ�ֵ
	public void getDataFromJPanel8() {

		MedicineService ms = new MedicineServiceImpl();
		Medicine medicine=new Medicine();
		getSharedValue(medicine);
		try {
			ms.addMedicine(medicine);
			int id = 0;
			try {
				id = ms.theLargestNumberOfMedicines(null).get(0).getId() + 1;
			} catch (QueryObjectException e) {
				e.printStackTrace();
			}
			object.getJtextFieldMap().get("ҩƷ���:").setText(String.valueOf(id));
			reflushJPanleTable();

		} catch (AddObjectException e) {
			e.printStackTrace();
		}
	}

	// ˢ��JPanel8�ı�����
	public void reflushJPanleTable() {
		DifferenceObject object7 = object.getDifferenceObjectMap().get(
				"object5").getDifferenceObjectMap().get("object7");
		String classification = (String) object.getJcomboBoxMap().get("ҩƷ���:")
				.getSelectedItem();
		Medicine medicine = new Medicine();
		medicine.setClassification(classification);
		MedicineService ms = new MedicineServiceImpl();
		SharedModel sharedModel = object7.getSharedModel();
		try {
			sharedModel.setPatientArrays(ms.queryMedicines(medicine));
			object7.getJtable().updateUI();

		} catch (QueryObjectException e) {
			e.printStackTrace();
		}
	}

	//��JPanel9�ı��еõ�ֵ
	public void getDataFromJPanel9() {
		MedicineService ms = new MedicineServiceImpl();
		Medicine medicine=new Medicine();
		getSharedValue(medicine);
		try {
			ms.updateMedicine(medicine);
			reflushJPanleTable();

		} catch (UpdateObjectException e) {
			e.printStackTrace();
		}
	}

}
