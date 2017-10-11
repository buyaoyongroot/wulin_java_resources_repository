
// MFCDEMOforSDKDlg.h : ͷ�ļ�
//

#pragma once
#include "afxwin.h"
#include "afxcmn.h"
#include "sdkocx20ctrl1.h"


// CMFCDEMOforSDKDlg �Ի���
class CMFCDEMOforSDKDlg : public CDialogEx
{
// ����
public:
	CMFCDEMOforSDKDlg(CWnd* pParent = NULL);	// ��׼���캯��

// �Ի�������
	enum { IDD = IDD_MFCDEMOFORSDK_DIALOG };

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV ֧��


// ʵ��
protected:
	HICON m_hIcon;

	// ���ɵ���Ϣӳ�亯��
	virtual BOOL OnInitDialog();
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	DECLARE_MESSAGE_MAP()
public:
//	BOOL m_bw;
	int m_mode;
	int m_TYPE;
//	afx_msg void OnBnHotItemChangeBmp(NMHDR *pNMHDR, LRESULT *pResult);
	CButton m_controlMulti;
	BOOL m_ValueMulti;
	afx_msg void OnBnClickedBrowse();
	afx_msg void OnBnClickedBmp();
	afx_msg void OnBnClickedTif();
	afx_msg void OnBnClickedPdf();
	afx_msg void OnBnClickedPng();
	afx_msg void OnBnClickedGif();
	afx_msg void OnBnClickedJpg();
	afx_msg void OnBnClickedBw();
	afx_msg void OnBnClickedGl();
	afx_msg void OnBnClickedColor();
	afx_msg void OnBnClickedShowui();
	afx_msg void OnBnClickedSelect();
	afx_msg void OnHScroll(UINT nSBCode, UINT nPos, CScrollBar* pScrollBar);
	long m_brightness;
	CSliderCtrl m_sliderBrightness;
	CSliderCtrl m_sliderContrast;
	CSliderCtrl m_sliderThreshold;
	CSliderCtrl m_sliderCompress;
	long m_contrast;
	long m_threshold;
	long m_compress;
	int m_dpi;
	CComboBox m_comboDpi;
	afx_msg void OnCbnSelchangeCombodpi();
	BOOL m_checkADF;
	CButton m_ControlDuplex;
	BOOL m_checkDuplex;
	BOOL m_checkInvert;
	afx_msg void OnBnClickedCheckadf();
	int m_sx;
//	CString m_sy;
	int m_sy;
	int m_ex;
	int m_ey;
	CString m_filename;
	int m_index;
	CString m_path;
	CString m_sourceName;
	CStatic m_controlLogo;
	CSdkocx20ctrl1 m_sdkocx;
	afx_msg void OnBnClickedButtonscan();
};
