import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GroupDialog, HomeComponent } from './home.component';
import { HomeRoutingModule } from './home-routing.module';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/module/shared.module';
import { UsersListModule } from '../users-list/users-list.module';
import { MessagesModule } from '../messages/messages.module';
import {MatDialogModule} from '@angular/material/dialog';


@NgModule({
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule,
    SharedModule,
    UsersListModule,
    MessagesModule,
    MatDialogModule
  ],
  declarations: [HomeComponent, GroupDialog],
  entryComponents: [GroupDialog]
})
export class HomeModule { }
