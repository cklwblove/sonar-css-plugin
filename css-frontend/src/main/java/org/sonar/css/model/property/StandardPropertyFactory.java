/*
 * SonarQube CSS / SCSS / Less Analyzer
 * Copyright (C) 2013-2017 David RACODON
 * mailto: david.racodon@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.css.model.property;

import com.google.common.collect.ImmutableSet;

import java.util.*;

import org.sonar.css.model.property.standard.*;
import org.sonar.css.model.property.standard.Float;
import org.sonar.css.model.property.standard.System;

public class StandardPropertyFactory {

  private static final Set<Class> ALL_PROPERTY_CLASSES = ImmutableSet.of(
    Accelerator.class,
    AdditiveSymbols.class,
    AlignContent.class,
    AlignItems.class,
    AlignmentAdjust.class,
    AlignmentBaseline.class,
    AlignSelf.class,
    All.class,
    Animation.class,
    AnimationDelay.class,
    AnimationDirection.class,
    AnimationDuration.class,
    AnimationFillMode.class,
    AnimationIterationCount.class,
    AnimationName.class,
    AnimationPlayState.class,
    AnimationTimingFunction.class,
    AnyHover.class,
    AnyPointer.class,
    Appearance.class,
    AspectRatio.class,
    Azimuth.class,
    BackfaceVisibility.class,
    Background.class,
    BackgroundAttachment.class,
    BackgroundBlendMode.class,
    BackgroundClip.class,
    BackgroundColor.class,
    BackgroundImage.class,
    BackgroundImageTransform.class,
    BackgroundOrigin.class,
    BackgroundPosition.class,
    BackgroundPositionX.class,
    BackgroundPositionY.class,
    BackgroundRepeat.class,
    BackgroundSize.class,
    BaselineShift.class,
    Behavior.class,
    Binding.class,
    Bleed.class,
    BlockProgression.class,
    BlockSize.class,
    BookmarkLabel.class,
    BookmarkLevel.class,
    BookmarkState.class,
    Border.class,
    BorderBlockEnd.class,
    BorderBlockEndColor.class,
    BorderBlockEndStyle.class,
    BorderBlockEndWidth.class,
    BorderBlockStart.class,
    BorderBlockStartColor.class,
    BorderBlockStartStyle.class,
    BorderBlockStartWidth.class,
    BorderBottom.class,
    BorderBottomColor.class,
    BorderBottomLeftRadius.class,
    BorderBottomRightRadius.class,
    BorderBottomStyle.class,
    BorderBottomWidth.class,
    BorderBoundary.class,
    BorderCollapse.class,
    BorderColor.class,
    BorderEnd.class,
    BorderEndColor.class,
    BorderEndStyle.class,
    BorderEndWidth.class,
    BorderImage.class,
    BorderImageOutset.class,
    BorderImageRepeat.class,
    BorderImageSlice.class,
    BorderImageSource.class,
    BorderImageWidth.class,
    BorderInlineEnd.class,
    BorderInlineEndColor.class,
    BorderInlineEndStyle.class,
    BorderInlineEndWidth.class,
    BorderInlineStart.class,
    BorderInlineStartColor.class,
    BorderInlineStartStyle.class,
    BorderInlineStartWidth.class,
    BorderLeft.class,
    BorderLeftColor.class,
    BorderLeftStyle.class,
    BorderLeftWidth.class,
    BorderRadius.class,
    BorderRight.class,
    BorderRightColor.class,
    BorderRightStyle.class,
    BorderRightWidth.class,
    BorderSpacing.class,
    BorderStart.class,
    BorderStartColor.class,
    BorderStartStyle.class,
    BorderStartWidth.class,
    BorderStyle.class,
    BorderTop.class,
    BorderTopColor.class,
    BorderTopLeftRadius.class,
    BorderTopRightRadius.class,
    BorderTopStyle.class,
    BorderTopWidth.class,
    BorderWidth.class,
    Bottom.class,
    BoxAlign.class,
    BoxDecorationBreak.class,
    BoxDirection.class,
    BoxFlex.class,
    BoxFlexGroup.class,
    BoxLines.class,
    BoxOrdinalGroup.class,
    BoxOrient.class,
    BoxPack.class,
    BoxShadow.class,
    BoxSizing.class,
    BoxSnap.class,
    BoxSuppress.class,
    BreakAfter.class,
    BreakBefore.class,
    BreakInside.class,
    CaptionSide.class,
    Caret.class,
    CaretColor.class,
    CaretShape.class,
    Clear.class,
    Clip.class,
    ClipPath.class,
    ClipRule.class,
    Color.class,
    ColorGamut.class,
    ColorIndex.class,
    ColorInterpolation.class,
    ColorInterpolationFilters.class,
    ColorProfile.class,
    ColorRendering.class,
    ColumnCount.class,
    ColumnFill.class,
    ColumnGap.class,
    ColumnRule.class,
    ColumnRuleColor.class,
    ColumnRuleStyle.class,
    ColumnRuleWidth.class,
    Columns.class,
    ColumnSpan.class,
    ColumnWidth.class,
    Content.class,
    ContentZoomChaining.class,
    ContentZooming.class,
    ContentZoomLimit.class,
    ContentZoomLimitMax.class,
    ContentZoomLimitMin.class,
    ContentZoomSnap.class,
    ContentZoomSnapPoints.class,
    ContentZoomSnapType.class,
    CounterIncrement.class,
    CounterReset.class,
    CounterSet.class,
    Cue.class,
    CueAfter.class,
    CueBefore.class,
    Cursor.class,
    DeviceAspectRatio.class,
    DeviceHeight.class,
    DevicePixelRatio.class,
    DeviceWidth.class,
    Direction.class,
    Display.class,
    DominantBaseline.class,
    DropInitialAfterAdjust.class,
    DropInitialAfterAlign.class,
    DropInitialBeforeAdjust.class,
    DropInitialBeforeAlign.class,
    DropInitialSize.class,
    DropInitialValue.class,
    Elevation.class,
    EmptyCells.class,
    EnableBackground.class,
    Fallback.class,
    Fill.class,
    FillOpacity.class,
    FillRule.class,
    Filter.class,
    Fit.class,
    FitPosition.class,
    Flex.class,
    FlexBasis.class,
    FlexDirection.class,
    FlexFlow.class,
    FlexGrow.class,
    FlexShrink.class,
    FlexWrap.class,
    Float.class,
    FloatDefer.class,
    FloatOffset.class,
    FloatReference.class,
    FloodColor.class,
    FloodOpacity.class,
    FlowFrom.class,
    FlowInto.class,
    Font.class,
    FontDisplay.class,
    FontFamily.class,
    FontFeatureSettings.class,
    FontKerning.class,
    FontLanguageOverride.class,
    FontMaxSize.class,
    FontMinSize.class,
    FontOpticalSizing.class,
    FontSize.class,
    FontSizeAdjust.class,
    FontStretch.class,
    FontStyle.class,
    FontSynthesis.class,
    FontVariant.class,
    FontVariantAlternates.class,
    FontVariantCaps.class,
    FontVariantEastAsian.class,
    FontVariantLigatures.class,
    FontVariantNumeric.class,
    FontVariantPosition.class,
    FontVariationSettings.class,
    FontWeight.class,
    FootnoteDisplay.class,
    FootnotePolicy.class,
    GlyphOrientationHorizontal.class,
    GlyphOrientationVertical.class,
    Grid.class,
    GridArea.class,
    GridAutoColumns.class,
    GridAutoFlow.class,
    GridAutoRows.class,
    GridCellStacking.class,
    GridColumn.class,
    GridColumnAlign.class,
    GridColumnEnd.class,
    GridColumnGap.class,
    GridColumns.class,
    GridColumnSizing.class,
    GridColumnSpan.class,
    GridColumnStart.class,
    GridFlow.class,
    GridGap.class,
    GridLayer.class,
    GridRow.class,
    GridRowAlign.class,
    GridRowEnd.class,
    GridRowGap.class,
    GridRows.class,
    GridRowSizing.class,
    GridRowSpan.class,
    GridRowStart.class,
    GridTemplate.class,
    GridTemplateAreas.class,
    GridTemplateColumns.class,
    GridTemplateRows.class,
    HangingPunctuation.class,
    Height.class,
    HighContrast.class,
    HighContrastAdjust.class,
    Hover.class,
    HyphenateAfter.class,
    HyphenateBefore.class,
    HyphenateCharacter.class,
    HyphenateLimitChars.class,
    HyphenateLimitLast.class,
    HyphenateLimitLines.class,
    HyphenateLimitZone.class,
    HyphenateLines.class,
    HyphenateResource.class,
    Hyphens.class,
    ImageOrientation.class,
    ImageRendering.class,
    ImageResolution.class,
    ImeMode.class,
    InitialLetter.class,
    InitialLetterAlign.class,
    InitialLetterWrap.class,
    InlineBoxAlign.class,
    InlineSize.class,
    Isolation.class,
    JustifyContent.class,
    JustifyItems.class,
    JustifySelf.class,
    Kerning.class,
    LayoutFlow.class,
    LayoutGrid.class,
    LayoutGridChar.class,
    LayoutGridLine.class,
    LayoutGridMode.class,
    LayoutGridType.class,
    Left.class,
    LetterSpacing.class,
    LightingColor.class,
    LineBreak.class,
    LineGrid.class,
    LineHeight.class,
    LineSnap.class,
    LineStacking.class,
    LineStackingRuby.class,
    LineStackingShift.class,
    LineStackingStrategy.class,
    ListStyle.class,
    ListStyleImage.class,
    ListStylePosition.class,
    ListStyleType.class,
    Margin.class,
    MarginBlockEnd.class,
    MarginBlockStart.class,
    MarginBottom.class,
    MarginEnd.class,
    MarginInlineEnd.class,
    MarginInlineStart.class,
    MarginLeft.class,
    MarginRight.class,
    MarginStart.class,
    MarginTop.class,
    Marker.class,
    MarkerEnd.class,
    MarkerMid.class,
    MarkerSide.class,
    MarkerStart.class,
    Marks.class,
    Marquee.class,
    MarqueeDir.class,
    MarqueeDirection.class,
    MarqueeIncrement.class,
    MarqueeLoop.class,
    MarqueePlayCount.class,
    MarqueeRepetition.class,
    MarqueeSpeed.class,
    MarqueeStyle.class,
    Mask.class,
    MaskBorder.class,
    MaskBorderMode.class,
    MaskBorderOutset.class,
    MaskBorderRepeat.class,
    MaskBorderSlice.class,
    MaskBorderSource.class,
    MaskBorderWidth.class,
    MaskClip.class,
    MaskComposite.class,
    MaskImage.class,
    MaskMode.class,
    MaskOrigin.class,
    MaskPosition.class,
    MaskRepeat.class,
    MaskSize.class,
    MaskType.class,
    MaxBlockSize.class,
    MaxDevicePixelRatio.class,
    MaxHeight.class,
    MaxInlineSize.class,
    MaxLines.class,
    MaxWidth.class,
    MaxZoom.class,
    MinBlockSize.class,
    MinDevicePixelRatio.class,
    MinHeight.class,
    MinInlineSize.class,
    MinWidth.class,
    MinZoom.class,
    MixBlendMode.class,
    Monochrome.class,
    Motion.class,
    MotionOffset.class,
    MotionPath.class,
    MotionRotation.class,
    MoveTo.class,
    NavDown.class,
    NavIndex.class,
    NavLeft.class,
    NavRight.class,
    NavUp.class,
    Negative.class,
    ObjectFit.class,
    ObjectPosition.class,
    OffsetAfter.class,
    OffsetAnchor.class,
    OffsetBefore.class,
    OffsetBlockEnd.class,
    OffsetBlockStart.class,
    OffsetDistance.class,
    OffsetEnd.class,
    OffsetInlineEnd.class,
    OffsetInlineStart.class,
    OffsetOrigin.class,
    OffsetPath.class,
    OffsetRotation.class,
    OffsetStart.class,
    Opacity.class,
    Order.class,
    Orientation.class,
    Orphans.class,
    Outline.class,
    OutlineColor.class,
    OutlineOffset.class,
    OutlineStyle.class,
    OutlineWidth.class,
    Overflow.class,
    OverflowBlock.class,
    OverflowInline.class,
    OverflowStyle.class,
    OverflowWrap.class,
    OverflowX.class,
    OverflowY.class,
    Pad.class,
    Padding.class,
    PaddingBlockEnd.class,
    PaddingBlockStart.class,
    PaddingBottom.class,
    PaddingEnd.class,
    PaddingInlineEnd.class,
    PaddingInlineStart.class,
    PaddingLeft.class,
    PaddingRight.class,
    PaddingStart.class,
    PaddingTop.class,
    Page.class,
    PageBreakAfter.class,
    PageBreakBefore.class,
    PageBreakInside.class,
    PagePolicy.class,
    Pause.class,
    PauseAfter.class,
    PauseBefore.class,
    Perspective.class,
    PerspectiveOrigin.class,
    Phonemes.class,
    Pitch.class,
    PitchRange.class,
    PlaceContent.class,
    PlaceItems.class,
    PlaceSelf.class,
    PlayDuring.class,
    Pointer.class,
    PointerEvents.class,
    Position.class,
    Prefix.class,
    PresentationLevel.class,
    ProgressAppearance.class,
    PunctuationTrim.class,
    Quotes.class,
    Range.class,
    RegionFragment.class,
    Resize.class,
    Resolution.class,
    Rest.class,
    RestAfter.class,
    RestBefore.class,
    Richness.class,
    Right.class,
    Rotation.class,
    RotationPoint.class,
    RubyAlign.class,
    RubyMerge.class,
    RubyOverhang.class,
    RubyPosition.class,
    RubySpan.class,
    Scan.class,
    Scollbar3dlightColor.class,
    ScollbarArrowColor.class,
    ScollbarBaseColor.class,
    ScollbarDarkShadowColor.class,
    Scripting.class,
    Scrollbar3dlightColor.class,
    ScrollbarDarkshadowColor.class,
    ScrollbarFaceColor.class,
    ScrollbarHighlightColor.class,
    ScrollbarShadowColor.class,
    ScrollbarTrackColor.class,
    ScrollBehavior.class,
    ScrollChaining.class,
    ScrollLimit.class,
    ScrollLimitXMax.class,
    ScrollLimitXMin.class,
    ScrollLimitYMax.class,
    ScrollLimitYMin.class,
    ScrollRails.class,
    ScrollSnapAlign.class,
    ScrollSnapMargin.class,
    ScrollSnapMarginBlock.class,
    ScrollSnapMarginBlockEnd.class,
    ScrollSnapMarginBlockStart.class,
    ScrollSnapMarginBottom.class,
    ScrollSnapMarginInline.class,
    ScrollSnapMarginInlineEnd.class,
    ScrollSnapMarginInlineStart.class,
    ScrollSnapMarginLeft.class,
    ScrollSnapMarginRight.class,
    ScrollSnapMarginTop.class,
    ScrollSnapPadding.class,
    ScrollSnapPaddingBlock.class,
    ScrollSnapPaddingBlockEnd.class,
    ScrollSnapPaddingBlockStart.class,
    ScrollSnapPaddingBottom.class,
    ScrollSnapPaddingInline.class,
    ScrollSnapPaddingInlineEnd.class,
    ScrollSnapPaddingInlineStart.class,
    ScrollSnapPaddingLeft.class,
    ScrollSnapPaddingRight.class,
    ScrollSnapPaddingTop.class,
    ScrollSnapPointsX.class,
    ScrollSnapPointsY.class,
    ScrollSnapStop.class,
    ScrollSnapType.class,
    ScrollSnapX.class,
    ScrollSnapY.class,
    ScrollTranslation.class,
    Shape.class,
    ShapeImageThreshold.class,
    ShapeInside.class,
    ShapeMargin.class,
    ShapeOutside.class,
    ShapeRendering.class,
    Size.class,
    Speak.class,
    SpeakAs.class,
    SpeakHeader.class,
    SpeakNumeral.class,
    SpeakPunctuation.class,
    SpeechRate.class,
    Src.class,
    StopColor.class,
    StopOpacity.class,
    Stress.class,
    StringSet.class,
    Stroke.class,
    StrokeDasharray.class,
    StrokeDashoffset.class,
    StrokeLinecap.class,
    StrokeLinejoin.class,
    StrokeMiterlimit.class,
    StrokeOpacity.class,
    StrokeWidth.class,
    Suffix.class,
    Symbols.class,
    System.class,
    TableLayout.class,
    TabSize.class,
    Target.class,
    TargetName.class,
    TargetNew.class,
    TargetPosition.class,
    TextAlign.class,
    TextAlignAll.class,
    TextAlignLast.class,
    TextAnchor.class,
    TextAutoSpace.class,
    TextCombineHorizontal.class,
    TextCombineUpright.class,
    TextDecoration.class,
    TextDecorationColor.class,
    TextDecorationLine.class,
    TextDecorationSkip.class,
    TextDecorationStyle.class,
    TextEmphasis.class,
    TextEmphasisColor.class,
    TextEmphasisPosition.class,
    TextEmphasisStyle.class,
    TextHeight.class,
    TextIndent.class,
    TextJustify.class,
    TextKashidaSpace.class,
    TextOrientation.class,
    TextOutline.class,
    TextOverflow.class,
    TextRendering.class,
    TextShadow.class,
    TextSizeAdjust.class,
    TextSpaceCollapse.class,
    TextSpaceTrim.class,
    TextSpacing.class,
    TextStroke.class,
    TextTransform.class,
    TextUnderlinePosition.class,
    TextWrap.class,
    Top.class,
    TouchAction.class,
    Transform.class,
    TransformBox.class,
    TransformOrigin.class,
    TransformStyle.class,
    Transition.class,
    TransitionDelay.class,
    TransitionDuration.class,
    TransitionProperty.class,
    TransitionTimingFunction.class,
    UnicodeBidi.class,
    UnicodeRange.class,
    Update.class,
    UserModify.class,
    UserSelect.class,
    UserZoom.class,
    VerticalAlign.class,
    ViewportFit.class,
    ViewState.class,
    Visibility.class,
    VoiceBalance.class,
    VoiceDuration.class,
    VoiceFamily.class,
    VoicePitch.class,
    VoiceRange.class,
    VoiceRate.class,
    VoiceStress.class,
    VoiceVolume.class,
    Volume.class,
    WhiteSpace.class,
    WhiteSpaceCollapse.class,
    Widows.class,
    Width.class,
    WillChange.class,
    WordBreak.class,
    WordSpacing.class,
    WordWrap.class,
    WrapAfter.class,
    WrapBefore.class,
    WrapFlow.class,
    WrapInside.class,
    WrapMargin.class,
    WrapThrough.class,
    WritingMode.class,
    ZIndex.class,
    Zoom.class);

  private static final Map<String, StandardProperty> ALL = new HashMap<>();

  static {
    try {
      StandardProperty standardProperty;
      for (Class clazz : ALL_PROPERTY_CLASSES) {
        standardProperty = (StandardProperty) clazz.newInstance();
        ALL.put(standardProperty.getName(), standardProperty);
      }
    } catch (InstantiationException | IllegalAccessException e) {
      throw new IllegalStateException("CSS property full list cannot be created.", e);
    }
  }

  private StandardPropertyFactory() {
  }

  public static StandardProperty getByName(String propertyName) {
    StandardProperty standardProperty = ALL.get(propertyName.toLowerCase(Locale.ENGLISH));
    return standardProperty != null ? standardProperty : new UnknownProperty(propertyName);
  }

  public static List<StandardProperty> getAll() {
    return new ArrayList<>(ALL.values());
  }

}
