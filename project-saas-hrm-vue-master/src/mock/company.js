import Mock from 'mockjs'
import { param2Obj } from '@/utils'

const List = []
const count = 100

for (let i = 0; i < 10; i++) {
    let data = {
        id: '1' + i,
        name: '企业' + i,
        managerId: 'string',
        version: '试用版v1.0',
        renewalDate: '2018-01-01',
        expirationDate: '2019-01-01',
        companyArea: '山东济南历下区',
        companyAddress: '力高国际',
        businessLicenseId: 'string',
        legalRepresentative: 'mr.yangtk',
        companyPhone: '18854000080',
        mailbox: 'yangtongkuan@qq.com',
        companySize: '15人以下',
        industry: 'string',
        remarks: 'string',
        auditState: '1',
        state: '1',
        balance: '0.0',
        createTime: '2020-12-12'
    }
  List.push(data)
}

export default {
  list: () => {
    return {
        code: 10000,
        success: true,
        message: '查询成功',
        data: List
    }
  },
  sassDetail: () => {
    return {
      code: 10000,
      success: true,
      message: '查询成功',
      data: {
        id: '10001',
        name: '测试企业',
        managerId: 'string',
        version: '试用版v1.0',
        renewalDate: '2018-01-01',
        expirationDate: '2019-01-01',
        companyArea: 'string',
        companyAddress: 'string',
        businessLicenseId: 'string',
        legalRepresentative: 'string',
        companyPhone: '13800138000',
        mailbox: 'string',
        companySize: 'string',
        industry: 'string',
        remarks: 'string',
        auditState: 'string',
        state: '1',
        balance: 'string',
        createTime: 'string'
      }
    }
  }
}
