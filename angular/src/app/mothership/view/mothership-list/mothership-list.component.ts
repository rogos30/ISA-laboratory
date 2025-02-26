import {Component, OnInit} from '@angular/core';
import {Motherships} from '../../model/motherships';
import {MothershipService} from '../../service/mothership.service';
import {Mothership} from '../../model/mothership';

@Component({
  selector: 'app-mothership-list',
  templateUrl: './mothership-list.component.html',
  standalone: false,
  styleUrls: ['./mothership-list.component.css']
})
export class MothershipListComponent implements OnInit {
  constructor(private service: MothershipService) {
  }

  motherships: Motherships | undefined;

  ngOnInit() {
    this.service.getMotherships().subscribe(motherships => this.motherships = motherships);
  }

  onDelete(mothership: Mothership): void {
    this.service.deleteMothership(mothership.id).subscribe(() => this.ngOnInit());
  }
}
