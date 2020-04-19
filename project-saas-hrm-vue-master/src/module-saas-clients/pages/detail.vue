<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card shadow="never">
        <el-tabs v-model="activeName">
          <el-tab-pane label="企业信息" name="first">
            <el-form ref="form" :model="detailItem" label-width="200px">
              <el-form-item label="公司名称:">
                <el-input v-model="detailItem.name"  style="width:250px" disabled></el-input>
              </el-form-item>
              <el-form-item label="当前版本:">
                <el-input v-model="detailItem.version"  style="width:250px" disabled></el-input>
              </el-form-item>
              <el-form-item label="到期时间:">
                <el-input v-model="detailItem.expirationDate"  style="width:250px" disabled></el-input>
              </el-form-item>
              <el-form-item label="公司地区:">
                <el-input v-model="detailItem.companyArea"  style="width:250px" disabled></el-input>
              </el-form-item>
              <el-form-item label="公司地址:">
                <el-input v-model="detailItem.companyAddress"  style="width:250px" disabled></el-input>
              </el-form-item>
              <el-form-item label="法人代表:">
                <el-input v-model="detailItem.legalRepresentative"  style="width:250px" disabled></el-input>
              </el-form-item>
              <el-form-item label="公司电话:">
                <el-input v-model="detailItem.companyPhone"  style="width:250px" disabled></el-input>
              </el-form-item>
              <el-form-item label="公司邮箱:">
                <el-input v-model="detailItem.mailbox"  style="width:250px" disabled></el-input>
              </el-form-item>
              <el-form-item label="公司规模:">
                <el-input v-model="detailItem.companySize"  style="width:250px" disabled></el-input>
              </el-form-item>
              <el-form-item label="所属行业:">
                <el-input v-model="detailItem.industry" style="width:250px" disabled></el-input>
              </el-form-item>
              <el-form-item label="审核状态:">
                <el-switch
                  v-model="detailItem.auditState"
                  active-color="#13ce66"
                  inactive-color="#ff4949"
                  active-value="1"
                  inactive-value="0" disabled>
                </el-switch>
                <!-- <el-input v-model="detailItem.auditState" style="width:250px" disabled></el-input> -->
              </el-form-item>
              <el-form-item label="状态:">
                <el-switch
                  v-model="detailItem.state"
                  active-color="#13ce66"
                  inactive-color="#ff4949"
                  active-value="1"
                  inactive-value="0" disabled>
                </el-switch>
                <!-- <el-input v-model="detailItem.state" style="width:250px" disabled></el-input> -->
              </el-form-item>
              <el-form-item label="当前余额:">
                <el-input v-model="detailItem.balance" style="width:250px" disabled></el-input>
              </el-form-item>
              <el-form-item label="创建时间:">
                <el-input v-model="detailItem.createTime" style="width:250px" disabled></el-input>
              </el-form-item>
              <el-form-item label="备注:">
                <el-input type="textarea" v-model="detailItem.remarks"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary">立即创建</el-button>
                <el-button>取消</el-button>
              </el-form-item>
            </el-form>
          </el-tab-pane>
          <el-tab-pane label="账户信息" name="second">账户信息</el-tab-pane>
          <el-tab-pane label="交易记录" name="third">交易记录</el-tab-pane>
        </el-tabs>
      </el-card>
     </div>
  </div>
</template>

<script>
import {detail} from '@/api/base/saasclients'
export default {
  data() {
    return {
      activeName: 'first',
      detailItem: {}
    }
  },
  methods: {
      getDetail: function(id) {
        detail({id: id}).then(res => {
          console.log(res.data.data)
          this.detailItem = res.data.data
        })
      }
  },
  // 创建完毕状态
  created() {
    var id = this.$route.params.id
    console.log(id)
    this.getDetail(id)
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.alert {
  margin: 10px 0px 0px 0px;
}
.pagination {
  margin-top: 10px;
  text-align: right;
}
</style>
