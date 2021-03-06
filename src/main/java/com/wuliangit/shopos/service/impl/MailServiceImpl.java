package com.wuliangit.shopos.service.impl;

import com.github.pagehelper.PageHelper;
import com.wuliangit.shopos.common.CoreConstants;
import com.wuliangit.shopos.common.mail.MailSender;
import com.wuliangit.shopos.common.util.StringArrayUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.dao.StoreMessageMapper;
import com.wuliangit.shopos.dto.StoreMailDTO;
import com.wuliangit.shopos.dto.StoreMessageDTO;
import com.wuliangit.shopos.entity.Admin;
import com.wuliangit.shopos.entity.StoreMessage;
import com.wuliangit.shopos.service.MailService;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nilme on 2017/4/29.
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private StoreMessageMapper storeMessageMapper;

    @Override
    public String sendMail(StoreMessageDTO storeMessageDTO) {
        try {
            List<String> mail = StringArrayUtils.dissloveQuotation(storeMessageDTO.getReceiveMail());
            List<String> name = StringArrayUtils.dissloveQuotation(storeMessageDTO.getReceiveUsername());
            List<String> id = StringArrayUtils.dissloveQuotation(storeMessageDTO.getReceiveUserIds());
            VelocityContext context = new VelocityContext();
            context.put("title",storeMessageDTO.getTitle());
            context.put("content",storeMessageDTO.getContent());
            MailSender.getSender().send(mail,context,storeMessageDTO.getTemplates());
            Admin admin = (Admin)WebUtil.getSession().getAttribute(CoreConstants.SESSION_CURRENT_ADMIN);
            List<StoreMessage> storeMessages = new ArrayList<StoreMessage>();
            for(int i=0;i<mail.size();i++){
                StoreMessage storeMessage = new StoreMessage();
                if(!mail.get(i).equals("") && mail.get(i) != null){
                    storeMessage.setSendUserId(admin.getAdminId());
                    storeMessage.setSendUserName(admin.getUsername());
                    storeMessage.setCreateTime(new Date());
                    storeMessage.setReceiveUserId(Integer.parseInt(id.get(i)));
                    storeMessage.setReceiveUserName(name.get(i));
                    storeMessage.setReadFlag(false);
                    storeMessage.setDelFlag(false);
                    storeMessage.setTitle(storeMessageDTO.getTitle());
                    storeMessage.setContent(storeMessageDTO.getContent());
                }
                storeMessages.add(storeMessage);
            }
            Integer info = storeMessageMapper.insertMessage(storeMessages);
            if(!(info > 0))return "error";
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public Integer getMessageCount(Integer storeId) {
        return storeMessageMapper.getMessageCount(storeId);
    }

    @Override
    public List<StoreMailDTO> getMailListDate(String searchKey, String orderColumn, String orderType, Integer page, Integer pageSize, Integer storeId) {
        PageHelper.startPage(page,pageSize);
        List<StoreMailDTO> storeMailDTOS = storeMessageMapper.getMailListDate(searchKey, orderColumn, orderType, storeId);
        return storeMailDTOS;
    }

    @Override
    public Integer deleteMessage(Integer storeMessageId) {
        return storeMessageMapper.deleteMessage(storeMessageId);
    }

    @Override
    public StoreMailDTO detailMail(Integer messageId,Integer storeId) {
        return storeMessageMapper.detailMail(messageId,storeId);
    }

    @Override
    public Integer updateReadFlag(Integer storeMessageId) {
        return storeMessageMapper.updateReadFlag(storeMessageId);
    }
}
