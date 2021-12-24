import {Component, Input, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Product} from '../../model/product';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  product: Product;
  productForm: FormGroup;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private formBuilder: FormBuilder,
              private router: Router) {
  }

  ngOnInit(): void {
    // let id1 = this.activatedRoute.snapshot.params['id'];
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = paramMap.get('id');
      this.product = this.productService.getById(parseInt(id));
    });
    this.productForm = this.formBuilder.group({
      id: [this.product.id],
      name: [this.product.name],
      price: [this.product.price],
      description: [this.product.description]
    });
  }

  onSubmit() {
    if (this.productForm.valid) {
      this.productService.updateProduct(this.productForm.value);
      this.router.navigateByUrl('product/list');
    }

  }
}
