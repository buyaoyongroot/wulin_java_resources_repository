
// MFCDEMOforSDK.h : PROJECT_NAME Ӧ�ó������ͷ�ļ�
//

#pragma once

#ifndef __AFXWIN_H__
	#error "�ڰ������ļ�֮ǰ������stdafx.h�������� PCH �ļ�"
#endif

#include "resource.h"		// ������


// CMFCDEMOforSDKApp:
// �йش����ʵ�֣������ MFCDEMOforSDK.cpp
//

class CMFCDEMOforSDKApp : public CWinApp
{
public:
	CMFCDEMOforSDKApp();

// ��д
public:
	virtual BOOL InitInstance();

// ʵ��

	DECLARE_MESSAGE_MAP()
};

extern CMFCDEMOforSDKApp theApp;