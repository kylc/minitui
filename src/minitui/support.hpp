#pragma once

#include <vector>

#include <ftxui/dom/elements.hpp>
#include <jank/runtime/convert.hpp>
#include <jank/runtime/oref.hpp>
#include <jank/runtime/sequence_range.hpp>

namespace minitui
{
  inline std::function<std::vector<int>(int, int)> wrap_graph(jank::runtime::object_ref f)
  {
    return [=](int width, int height) {
      auto out = f.call(jank::runtime::make_box(width), jank::runtime::make_box(height));
      std::vector<int> output;
      for(auto y : make_sequence_range(out))
      {
        output.push_back(y.to_integer());
      }
      return output;
    };
  }
}

namespace jank::runtime
{
  template <>
  struct convert<ftxui::Element>
  {
    static object_ref into_object(ftxui::Element v)
    {
      // TODO: This is pretty much jank's generated code for cpp/new,
      // implemented in a conversion trait.
      static auto const finalizer([](void * const obj, void *) {
        using T = std::shared_ptr<ftxui::Node>;
        reinterpret_cast<T *>(obj)->~T();
      });
      auto *v_ref = new(UseGC, finalizer) ftxui::Element(std::move(v));

      return make_box<obj::opaque_box>(v_ref, "std::shared_ptr<ftxui::Node>*");
    }

    static ftxui::Element from_object(object_ref o)
    {
      // TODO: This is cpp/unbox, in a conversion trait.
      auto box = try_object<obj::opaque_box>(o);
      if(!box->canonical_type.empty() && box->canonical_type != "std::shared_ptr<ftxui::Node>*")
      {
        throw std::runtime_error("not an ftxui::Element");
      }

      return *static_cast<ftxui::Element *>(box->data.data);
    }
  };
}
