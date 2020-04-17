<template>
  <div class="dashboard-container">
    <div class="app-container">
      <el-card shadow="never">
        saas企业管理
      </el-card>
     </div>
  </div>
</template>

<script>
import {list} from '@/api/base/saasclients'
export default {
  data() {
    return {
      getCompanyList: function() {
        list().then(res => {
          console.log(res.data.data)
        })
      }
     
    }
  },
  methods: {
  },
  // 创建完毕状态
  created() {
    this.getCompanyList()
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
