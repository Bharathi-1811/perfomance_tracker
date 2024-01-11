import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { LoginModule } from './login/login.module';
import { AdminloginModule } from './adminlogin/adminlogin.module';
import { SignupModule } from './signup/signup.module';
import { TraineeAnnounceComponent } from './trainee-announce/trainee-announce.component';
import { TraineeResultComponent } from './trainee-result/trainee-result.component';
import { TraineeDashboardComponent } from './trainee-dashboard/trainee-dashboard.component';
import { TraineeSidenavComponent } from './trainee-sidenav/trainee-sidenav.component';

import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatIconModule} from '@angular/material/icon';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import { TraineeTopnavbarComponent } from './trainee-topnavbar/trainee-topnavbar.component';
import { AdminSidenavComponent } from './admin/admin-sidenav/admin-sidenav.component';
import { AdminTopnavComponent } from './admin/admin-topnav/admin-topnav.component';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { TraineeBodyComponent } from './trainee-body/trainee-body.component';
import { HomeBodyComponent } from './home-body/home-body.component';
import { AdminBodyComponent } from './admin/admin-body/admin-body.component';
import { ManageBatchComponent } from './admin/batch/manage-batch/manage-batch.component';
import { ManageTopicComponent } from './admin/topic/manage-topic/manage-topic.component';
import { HttpClientModule } from '@angular/common/http';
import { CreateTopicComponent } from './admin/topic/create-topic/create-topic.component';
import { UpdateTopicComponent } from './admin/topic/update-topic/update-topic.component';
import { ManageUpcomingComponent } from './admin/upcomingannouncements/manage-upcoming/manage-upcoming.component';
import { CreateUpcomingComponent } from './admin/upcomingannouncements/create-upcoming/create-upcoming.component';
import { UpdateUpcomingComponent } from './admin/upcomingannouncements/update-upcoming/update-upcoming.component';
import { CreateBatchComponent } from './admin/batch/create-batch/create-batch.component';
import { UpdateBatchComponent } from './admin/batch/update-batch/update-batch.component';
import { ResultAddComponent } from './admin/result/result-add/result-add.component';
import { ResultManageComponent } from './admin/result/result-manage/result-manage.component';
import { ResultEditComponent } from './admin/result/result-edit/result-edit.component';
import { CreateBatchTopicComboComponent } from './admin/batchtopiccombo/create-batch-topic-combo/create-batch-topic-combo.component';
import { ManageBatchTopicComboComponent } from './admin/batchtopiccombo/manage-batch-topic-combo/manage-batch-topic-combo.component';
import { EditBatchTopicComboComponent } from './admin/batchtopiccombo/edit-batch-topic-combo/edit-batch-topic-combo.component';
import { ResultPipe } from './admin/result/result.pipe';
import { ResultViewComponent } from './admin/result/result-view/result-view.component';
import { ManageTraineeComponent } from './admin/manage-trainees/manage-trainee/manage-trainee.component';
import { UpdateTraineeComponent } from './admin/manage-trainees/update-trainee/update-trainee.component';
import { AddTraineeComponent } from './admin/manage-trainees/add-trainee/add-trainee.component';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { SignupverifyComponent } from './signup/signupverify/signupverify.component';
import { ManageBatchTraineeComboComponent } from './admin/batchtraineecombo/manage-batch-trainee-combo/manage-batch-trainee-combo.component';
import { CreateBatchTraineeComboComponent } from './admin/batchtraineecombo/create-batch-trainee-combo/create-batch-trainee-combo.component';
import { EditBatchTraineeComboComponent } from './admin/batchtraineecombo/edit-batch-trainee-combo/edit-batch-trainee-combo.component';
import { HighchartsChartModule } from 'highcharts-angular';
import { TraineeGraphComponent } from './trainee-graph/trainee-graph.component';
import { TraineeGraphPiechartComponent } from './admin/result/graph-piechart/trainee-graph-piechart.component';
import { FilterPipe } from './admin/admin-dashboard/filter.pipe';
import { ViewprofileComponent } from './traineeprofile/viewprofile/viewprofile.component';
import { EditprofileComponent } from './traineeprofile/editprofile/editprofile.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { AdminTraineeViewComponent } from './admin-trainee-view/admin-trainee-view.component';
import { TraineeTopicComponent } from './trainee-topic/trainee-topic.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    TraineeAnnounceComponent,
    TraineeResultComponent,
    TraineeDashboardComponent,
    TraineeSidenavComponent,
    TraineeTopnavbarComponent,
    AdminSidenavComponent,
    AdminTopnavComponent,
    AdminDashboardComponent,
    TraineeBodyComponent,
    HomeBodyComponent,
    AdminBodyComponent,
    ManageBatchComponent,
    ManageTopicComponent,
    CreateTopicComponent,
    UpdateTopicComponent,
    ManageUpcomingComponent,
    CreateUpcomingComponent,
    UpdateUpcomingComponent,
    CreateBatchComponent,
    UpdateBatchComponent,
    ResultAddComponent,
    ResultManageComponent,
    ResultEditComponent,
    CreateBatchTopicComboComponent,
    ManageBatchTopicComboComponent,
    EditBatchTopicComboComponent,
    ResultPipe,
    ResultViewComponent,
    ManageTraineeComponent,
    UpdateTraineeComponent,
    AddTraineeComponent,
    SignupverifyComponent,
    ManageBatchTraineeComboComponent,
    CreateBatchTraineeComboComponent,
    EditBatchTraineeComboComponent,
    TraineeGraphComponent,
    TraineeGraphPiechartComponent,
    FilterPipe,
    ViewprofileComponent,
    EditprofileComponent,
    ChangepasswordComponent,
    AdminTraineeViewComponent,
    TraineeTopicComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LoginModule,
    AdminloginModule,
    SignupModule,
    MatSlideToggleModule,
    MatIconModule,
    FormsModule,
    ReactiveFormsModule,
    MatToolbarModule,
    MatMenuModule,
    MatButtonModule,
    HttpClientModule,
    MatSnackBarModule,
    HighchartsChartModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
