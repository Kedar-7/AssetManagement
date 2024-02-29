import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssetrequestComponent } from './assetrequest.component';

describe('AssetrequestComponent', () => {
  let component: AssetrequestComponent;
  let fixture: ComponentFixture<AssetrequestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AssetrequestComponent]
    });
    fixture = TestBed.createComponent(AssetrequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
