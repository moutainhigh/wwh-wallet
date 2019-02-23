package com.wwh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wwh.dao.IMsgContryCodeDao;
import com.wwh.service.IMsgContryCodeService;
import com.wwh.vo.MsgContryCodeVO;

@Service
public class MsgContryCodeService implements IMsgContryCodeService {

	@Autowired
	private IMsgContryCodeDao msgContryCodeDao;

	@Override
	public List<MsgContryCodeVO> getMsgContryCodeList() {

		return msgContryCodeDao.getMsgContryCodeVO();
	}

}
