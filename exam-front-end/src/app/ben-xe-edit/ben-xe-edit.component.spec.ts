import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenXeEditComponent } from './ben-xe-edit.component';

describe('BenXeEditComponent', () => {
  let component: BenXeEditComponent;
  let fixture: ComponentFixture<BenXeEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenXeEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenXeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
