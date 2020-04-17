<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card shadow="never">
        <el-table :data="companyList" border stripe="true" style="width: 100%">
          <el-table-column fixed type="index" label="序号" width="50"></el-table-column>
          <el-table-column prop="name" label="企业名称" width="150"></el-table-column>
          <el-table-column prop="version" label="当前版本" width="100"></el-table-column>
          <el-table-column prop="expirationDate" label="到期时间" width="100"></el-table-column>
          <el-table-column prop="companyArea" label="公司地区" width="150"></el-table-column>
          <el-table-column prop="companyAddress" label="公司地址" width="150"></el-table-column>
          <el-table-column prop="legalRepresentative" label="法人代表" width="100"></el-table-column>
          <el-table-column prop="companyPhone" label="公司电话" width="150"></el-table-column>
          <el-table-column prop="mailbox" label="邮箱" width="150"></el-table-column>
          <el-table-column prop="auditState" label="审核状态" width="150"></el-table-column>
          <el-table-column prop="state" label="状态" width="150">
            <!-- 开关组件
              active-value : 激活时数据值
              inactive-value : 未激活时数据值
              active-color： 激活时颜色
              inactive-color： 未激活时颜色
            -->
            <template slot-scope="scope">
              <el-switch
                v-model="scope.row.state"
                active-color="#13ce66"
                inactive-color="#ff4949"
                active-value="1"
                inactive-value="0" disabled>
              </el-switch>
            </template>
          </el-table-column>
          <el-table-column prop="balance" label="余额" width="150"></el-table-column>
          <el-table-column fixed="right" label="操作" width="100">
            <template slot-scope="scope">
              <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
              <!-- <el-button type="text" size="small">编辑</el-button> -->
            </template>
          </el-table-column>
        </el-table>
      </el-card>
     </div>
  </div>
</template>

<script>
import {list} from '@/api/base/saasclients'
export default {
  data() {
    return {
     companyList: []
    }
  },
  methods: {
    getCompanyList: function() {
        list().then(res => {
          console.log(res.data.data)
          this.companyList = res.data.data
        })
      }
  },
  // 创建完毕状态
  created() {
    this.getCompanyList()
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
// body .el-table th.gutter{
//     display: table-cell!important;
// }
.el-table--border th.gutter:last-of-type {
    display: block !important;
    width: 17px !important;
}
.alert {
  margin: 10px 0px 0px 0px;
}
.pagination {
  margin-top: 10px;
  text-align: right;
}
</style>
