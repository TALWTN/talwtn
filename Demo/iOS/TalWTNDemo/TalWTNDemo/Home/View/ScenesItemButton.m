//
//  ScenesItemButton.m
//  veRTC_Demo
//
//  Created by TAL on 2021/5/26.
//  Copyright © 2021 . All rights reserved.
//

#import "ScenesItemButton.h"
#import "Masonry.h"

@interface ScenesItemButton ()

@property (nonatomic, strong) UIView *bgView;
@property (nonatomic, strong) UIView *bgSelectView;

@property (nonatomic, strong) UIImageView *iconImageView;
@property (nonatomic, strong) UIImageView *bgImageView;
@property (nonatomic, strong) UILabel *eventLabel;
@property (nonatomic, strong) UILabel *desclelabel;

@property (nonatomic, strong) UIImageView *indexImageView;

@property (nonatomic, assign) BOOL hasAddItemLayer;

@end

@implementation ScenesItemButton

- (instancetype)initWithFrame:(CGRect)frame{
    if (self = [super initWithFrame:frame]) {
        
        self.layer.cornerRadius = 20;
        self.layer.masksToBounds = YES;
        self.backgroundColor = [UIColor clearColor];
        
        [self addTarget:self action:@selector(touchUp:) forControlEvents:UIControlEventTouchUpInside];
        [self addTarget:self action:@selector(touchUp:) forControlEvents:UIControlEventTouchUpOutside];
        [self addTarget:self action:@selector(touchDown:) forControlEvents:UIControlEventTouchDown];
        [self addTarget:self action:@selector(touchUp:) forControlEvents:UIControlEventTouchCancel];
        
        [self addSubview:self.bgView];
        [self addSubview:self.bgSelectView];

        
        [self.bgView mas_makeConstraints:^(MASConstraintMaker *make) {
            make.edges.equalTo(self);
        }];
        [self.bgSelectView mas_makeConstraints:^(MASConstraintMaker *make) {
            make.edges.equalTo(self);
        }];

        [self addSubview:self.bgImageView];
        [self addSubview:self.iconImageView];
        [self addSubview:self.eventLabel];
        [self addSubview:self.desclelabel];
        [self addSubview:self.indexImageView];
                
        [self.iconImageView mas_makeConstraints:^(MASConstraintMaker *make) {
            make.size.mas_equalTo(CGSizeMake(34, 34));
            make.centerY.equalTo(self);
            make.left.mas_equalTo(32);
        }];
        
        [self.bgImageView mas_makeConstraints:^(MASConstraintMaker *make) {
            make.size.mas_equalTo(CGSizeMake(300 / 2, 236 / 2));
            make.center.equalTo(self.iconImageView);
        }];
       
        [self.eventLabel mas_makeConstraints:^(MASConstraintMaker *make) {
            make.left.equalTo(self.iconImageView.mas_right).mas_equalTo(30);
            make.top.equalTo(self).mas_equalTo(36);
            make.right.equalTo(self).mas_equalTo(200);
            make.height.mas_equalTo(20);
        }];
        
        [self.desclelabel mas_makeConstraints:^(MASConstraintMaker *make) {
            make.left.equalTo(self.iconImageView.mas_right).mas_equalTo(30);
            make.top.equalTo(self.eventLabel.mas_bottom).mas_equalTo(8);
            make.right.equalTo(self).mas_equalTo(200);
            make.height.mas_equalTo(20);
        }];
        
        [self.indexImageView mas_makeConstraints:^(MASConstraintMaker *make) {
            make.centerY.equalTo(self.mas_centerY);
            make.right.equalTo(self).mas_equalTo(-30);
            make.height.mas_equalTo(16);
            make.width.mas_equalTo(16);
        }];
        
    }
    return self;
}

- (void)layoutSubviews{
    [super layoutSubviews];
    
    if (_hasAddItemLayer == NO) {
        [self addItemLayer];
        _hasAddItemLayer = YES;
    }
}

#pragma mark - setter

- (void)setModel:(SceneButtonModel *)model{
    _model = model;
    self.iconImageView.image = [UIImage imageNamed:model.iconName];
    if (self.model.bgName) {
        self.bgImageView.image = [UIImage imageNamed:model.bgName];
    }
    self.eventLabel.text = model.title;
    self.desclelabel.text = model.descTitle;
}

#pragma mark - Publish Action

- (void)addItemLayer {
    [self addItemBgGradientLayer];
    [self addItemSelectBgGradientLayer];
}

#pragma mark - Private Action

- (void)touchUp:(UIButton *)sender {
    self.bgView.hidden = NO;
    self.bgSelectView.hidden = YES;
}

- (void)touchDown:(UIButton *)sender {
    self.bgView.hidden = YES;
    self.bgSelectView.hidden = NO;
}

- (void)addItemBgGradientLayer {
    UIColor *startColor = [UIColor colorFromHexString:@"#39455B"];
    UIColor *endColor = [UIColor colorFromRGBHexString:@"#39455B"];
    CAGradientLayer *gradientLayer = [CAGradientLayer layer];
    gradientLayer.frame = self.bgView.bounds;
    gradientLayer.colors = @[(__bridge id)[startColor colorWithAlphaComponent:1.0].CGColor,
                             (__bridge id)[endColor colorWithAlphaComponent:0.5].CGColor];
    gradientLayer.startPoint = CGPointMake(0.5, .0);
    gradientLayer.endPoint = CGPointMake(0.5, 1.0);
    [self.bgView.layer addSublayer:gradientLayer];
}

- (void)addItemSelectBgGradientLayer {
    UIColor *startColor = [UIColor colorFromRGBHexString:@"#39455B"];
    UIColor *endColor = [UIColor colorFromHexString:@"#39455B"];
    CAGradientLayer *gradientLayer = [CAGradientLayer layer];
    gradientLayer.frame = self.bgSelectView.bounds;
    gradientLayer.colors = @[(__bridge id)[startColor colorWithAlphaComponent:0.5].CGColor,
                             (__bridge id)[endColor colorWithAlphaComponent:1.0].CGColor];
    gradientLayer.startPoint = CGPointMake(0.5, .0);
    gradientLayer.endPoint = CGPointMake(0.5, 1.0);
    [self.bgSelectView.layer addSublayer:gradientLayer];
}

#pragma mark - getter
- (UIImageView *)iconImageView{
    if (_iconImageView == nil) {
        _iconImageView = [[UIImageView alloc] init];
        _iconImageView.contentMode = UIViewContentModeScaleAspectFit;
    }
    return _iconImageView;;
}

- (UIImageView *)bgImageView{
    if (_bgImageView == nil) {
        _bgImageView = [[UIImageView alloc] init];
        
    }
    return _bgImageView;
}

- (UIImageView *)indexImageView{
    if (_indexImageView == nil) {
        _indexImageView = [[UIImageView alloc] init];
        _indexImageView.image = [UIImage imageNamed:@"menu_list_more"];
        _indexImageView.contentMode = UIViewContentModeScaleAspectFit;
    }
    return _indexImageView;;
}



- (UILabel *)eventLabel {
    if (_eventLabel == nil) {
        _eventLabel = [[UILabel alloc] init];
        _eventLabel.textColor = [UIColor whiteColor];
        _eventLabel.font = [UIFont systemFontOfSize:18 weight:UIFontWeightRegular];
    }
    return _eventLabel;
}

- (UILabel *)desclelabel{
    if (_desclelabel == nil) {
        _desclelabel = [[UILabel alloc] init];
        _desclelabel.textColor = [UIColor colorWithRed:0.525 green:0.565 blue:0.612 alpha:1];
        _desclelabel.font = [UIFont systemFontOfSize:14 weight:UIFontWeightRegular];
    }
    return _desclelabel;
}

- (UIView *)bgView {
    if (!_bgView) {
        _bgView = [[UIView alloc] init];
        _bgView.userInteractionEnabled = NO;
    }
    return _bgView;
}

- (UIView *)bgSelectView {
    if (!_bgSelectView) {
        _bgSelectView = [[UIView alloc] init];
        _bgSelectView.userInteractionEnabled = NO;
        _bgSelectView.hidden = YES;
    }
    return _bgSelectView;
}

@end
