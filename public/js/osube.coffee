# CoffeeScript
(($) ->
  $("span.timeago").timeago()

  stack = []

  epic = $('#epic')
  epic.click ->
    if(epic.hasClass('active'))
      epic.removeClass('active')
      $("#events").html(stack.pop())
    else
      epic.addClass('active')
      stack.push($("#events").html())
      $(".epic-factor-1").remove();

  the_end = 'end'
) jQuery