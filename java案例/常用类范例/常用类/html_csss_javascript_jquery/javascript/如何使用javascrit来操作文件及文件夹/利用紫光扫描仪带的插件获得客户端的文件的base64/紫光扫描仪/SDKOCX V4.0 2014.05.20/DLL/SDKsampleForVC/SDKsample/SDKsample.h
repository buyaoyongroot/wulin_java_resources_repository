
// SDKsample.h : PROJECT_NAME Ӧ�ó������ͷ�ļ�
//

#pragma once

#ifndef __AFXWIN_H__
	#error "�ڰ������ļ�֮ǰ������stdafx.h�������� PCH �ļ�"
#endif

#include "resource.h"		// ������


// CSDKsampleApp:
// �йش����ʵ�֣������ SDKsample.cpp
//

class CSDKsampleApp : public CWinApp
{
public:
	CSDKsampleApp();

// ��д
public:
	virtual BOOL InitInstance();

// ʵ��

	DECLARE_MESSAGE_MAP()
};

extern CSDKsampleApp theApp;