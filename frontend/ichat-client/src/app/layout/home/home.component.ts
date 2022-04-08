import { Component, OnInit, HostListener, TemplateRef, ViewChild, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../shared/service/user.service';
import { RxStompService } from '@stomp/ng2-stompjs';
import { AuthService } from 'angularx-social-login';
import { MatDialog, MatDialogConfig, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatMenuTrigger } from '@angular/material';
import { Group } from 'src/app/shared/model/group';


@Component({
  selector: 'group-dialog',
  template: ` <mat-grid-tile class="login-form">
  <mat-form-field class="full-width">
    <input matInput placeholder="Username" class="login-input" type="text">
  </mat-form-field>
</mat-grid-tile>`,
})
export class GroupDialog {

  constructor() { }

  onNoClick(): void {
  }
}

@Component({
  selector: 'wt-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  private receiver: string;
  private username: string;
  popup: boolean = false;
  private userId: any;
  group: boolean = false;
  groupName: any;

  constructor(
    private router: Router,
    private userService: UserService,
    private stompService: RxStompService,
    private authService: AuthService,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.userId = sessionStorage.getItem('id');
    this.username = sessionStorage.getItem('user');
    if (this.username == null || this.username === '') {
      this.router.navigate(['/']);
    } else {
      this.userService.login({ 'id': null, 'username': this.username });
    }
  }

  @HostListener('window:unload', ['$event'])
  onUnload() {
    this.logout();
  }

  onReceiverChange(event) {
    this.receiver = event;
  }
  getInfo() {
    this.popup = !this.popup;
  }

  closePopup() {
    this.popup = false;
    this.group = false;
  }

  addGroup() {
    // const dialogRef = this.dialog.open(GroupDialog, {
    //   width: '500px'
    // });

    // dialogRef.afterClosed().subscribe(result => {
    //   console.log('The dialog was closed');
    // });
    this.group = !this.group;
  }

  logout() {
    this.userService.logout({ 'id': null, 'username': this.username })
      .subscribe(
        res => {
          this.logoutSocial();
        },
        error => {
          console.log(error._body);
        });
  }

  logoutSocial() {
    this.authService.signOut().then(() => {
      this.clearSession();
    },
      error => {
        this.clearSession();
      });
  }

  clearSession() {
    sessionStorage.removeItem('user');
    this.stompService.deactivate();
    this.username = null;
    this.router.navigate(['/']);
  }
}
function DialogDataExampleDialog(DialogDataExampleDialog: any, arg1: { data: { animal: string; }; }) {
  throw new Error('Function not implemented.');
}

